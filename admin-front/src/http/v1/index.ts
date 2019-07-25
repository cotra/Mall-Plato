/**
 * @Date 2019-07-25 13:33:31
 * @Remark
 */

// lib
import isNumber from "lodash/isNumber";
import isString from "lodash/isString";
// config
import { APP_SERVER } from "config/env";
// script & methods & public
import logUtils from "utils/logUtils";
// store
// http
import {
  IOpenOption,
  openOption,
  IData,
  HTTP_ERROR_CODE_MAP,
  CODE_SUCCESS
} from "../model";
import { createUrl, show } from "../core";
import { get, post } from "./link";
// interface && type && class
import { IApi, IRes, IResList, IResItem, IResError } from "api/core";
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
export function open<T, D>(
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
export function bag<T>(res: IResList): IData<T> {
  const data: IData<T> = {
    fail: "",
    err: "",
    payload: null
  };
  res.forEach((el: IResItem) => {
    // 打印结果
    logUtils.info(el, "response");
    // 错误
    if (isErrRes(el)) {
      const code = el.code;
      if (isNumber(code)) {
        data.err = HTTP_ERROR_CODE_MAP[code];
      }
    }
    // 失败
    if (isFailRes(el)) {
      data.fail = el.msg;
    }
  });
  // 返回
  return data;
}

// 成功返回
export function isOkRes<T>(test: IRes<T> | IResError): test is IRes<T> {
  if (isString(test.code)) {
    return test.code === CODE_SUCCESS;
  }
  return false;
}

// 失败返回
export function isFailRes<T>(test: IRes<T> | IResError): test is IResItem {
  if (isString(test.code)) {
    return test.code !== CODE_SUCCESS;
  }
  return false;
}

// 错误返回
export function isErrRes<T>(test: IRes<T> | IResError): test is IResError {
  if (isNumber(test.code)) {
    // 格式化为字符串
    const flag = test.code.toString();
    return flag !== CODE_SUCCESS && flag.length === 3; // 三位数的返回码是网络异常
  }
  return false;
}
