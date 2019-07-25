/**
 * @Date 2019-05-27 17:11:36
 * @Remark
 */

// lib
import isNumber from "lodash/isNumber";
// config
import { APP_SERVER } from "config/env";
// script & methods & public
import toast from "public/toast";
import logUtils from "utils/logUtils";
// store
// http
import {
  IOpenOption,
  openOption,
  IData,
  HTTP_ERROR_CODE_MAP,
  CODE_NOT_LOGIN,
  CODE_SUCCESS
} from "../model";
import { createUrl, show } from "../core";
import { get, post } from "./link";
// interface && type && class
import { IApi, IRes } from "api/core";
// 其它

/**
 * 打开接口
 */

// // 单个使用
// const a1 = await open<{}, IresOrderList>(apiOrderList, {});

// // 串联使用
// const req1 = open<{}, IresOrderList>(apiOrderList, {});
// const req2 = open<{}, IresOrderList>(apiOrderList, {});
// const a1 = await req1;
// const a2 = await req2;
export function open<T, D extends IRes>(
  api: IApi,
  payload: T,
  option: IOpenOption = openOption
) {
  // 设置url
  const url = createUrl(api, APP_SERVER.apiServer, option);
  // 打印请求信息
  show(api, url, payload);
  // 根据api信息确定请求格式
  if (api.method === "POST") {
    return post<T, D>(url, payload, option);
  }
  // 默认用get方式
  return get<T, D>(url, payload, option);
}

/**
 * 创建一个Idata的结构
 */
export function bag<T>(res: IRes[]): IData<T> {
  const data: IData<T> = {
    fail: "",
    err: "",
    payload: null
  };
  res.forEach((el: IRes) => {
    // 打印结果
    logUtils.info(el, "response");
    // 错误
    if (isErrRes(el)) {
      const code: string | number = el.result;
      if (isNumber(code)) {
        data.err = HTTP_ERROR_CODE_MAP[code];
      }
    }
    // 失败
    if (isFailRes(el)) {
      data.fail = el.msg || el.message || "无信息失败响应";
    }
    // 没有登录
    if (el.code && el.code === CODE_NOT_LOGIN) {
      toast.warn("您的登录授权失效，请重新登录");
      // resetAccount();
    }
  });
  // 返回
  return data;
}

// 数据格式化
export function formatResData<T>(params: string): T | null {
  try {
    const result: T = JSON.parse(params);
    return result;
  } catch (error) {
    logUtils.error(params, "返回数据JSON格式化失败");
    return null;
  }
}

// 成功返回
export function isOkRes<T extends IRes>(test: T | IRes): test is T {
  const code: string | number = test.result;
  if (isNumber(test.result)) {
    // 格式化为字符串
    const flag: string = isNumber(code) ? code.toString() : code;
    return flag === CODE_SUCCESS;
  }
  return false;
}

// 失败返回
export function isFailRes<T extends IRes>(test: T | IRes): test is T {
  const code: string | number = test.result;
  if (isNumber(test.result)) {
    // 格式化为字符串
    const flag: string = isNumber(code) ? code.toString() : code;
    return flag !== CODE_SUCCESS && flag.length !== 3; // 自定义的没有三位数的返回码
  }
  return false;
}

// 错误返回
export function isErrRes<T extends IRes>(test: T | IRes): test is IRes {
  const code: string | number = test.result;
  if (isNumber(test.result)) {
    // 格式化为字符串
    const flag: string = isNumber(code) ? code.toString() : code;
    return flag !== CODE_SUCCESS && flag.length === 3; // 三位数的返回码是网络异常
  }
  return false;
}
