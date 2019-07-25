/**
 * @Date 2019-05-14 14:49:49
 * @Remark
 */

// axios
import axios, { AxiosInstance } from "axios";
// lib
import queryString from "query-string";
import isObject from "lodash/isObject";
import isEmpty from "lodash/isEmpty";
// config
import { TIMEOUT_LONG, TIMEOUT_SHORT } from "config/setting";
// script & public
import logUtils from "utils/logUtils";
import timeUtils from "utils/timeUtils";
// interface && type && class
import { IApi } from "api/core";
import { IOpenOption } from "./model";
// 其它

// 打印接口信息
export function show(api: IApi, url: string, payload: any) {
  const msg = `api: ${api.title} || method: ${
    api.method
  } || url: ${url} || params: ${JSON.stringify(payload)}`;
  logUtils.info(msg, "request");
}

// 生成url
export function createUrl(
  api: IApi,
  server: string,
  option: IOpenOption
): string {
  // 本地静态资源
  if (option.static) {
    const staticUrl = `/${api.path}`;
    return staticUrl;
  }
  // api
  if (api.prefix !== "") {
    const apiUrl = `${server}/${api.prefix}/${api.path}`;
    return apiUrl;
  }
  // 无前缀
  const url = `${server}/${api.path}`;
  return url;
}

/**
 * axios实例创造方法
 */
export function createInstance(option: IOpenOption): AxiosInstance {
  // 超时设置
  let timeout = TIMEOUT_SHORT;
  if (option.long) {
    timeout = TIMEOUT_LONG;
  }
  if (typeof option.long === "number") {
    timeout = option.long;
  }
  // 创建和返回
  const newInstance: AxiosInstance = axios.create({
    timeout
  });
  return newInstance;
}

/**
 * get请求格式化参数
 */
export function setUrlWithParams(
  url: string,
  data: any,
  fresh?: boolean
): string {
  const timestamps = timeUtils.getTime();
  let link = url;
  if (isObject(data) && !isEmpty(data)) {
    const formatData = queryString.stringify(data);
    link = `${url}?${formatData}`;
    if (fresh) {
      link = `${link}&v=${timestamps}`;
    }
    return link;
  }
  if (fresh) {
    link = `${url}?v=${timestamps}`;
  }
  return link;
}
