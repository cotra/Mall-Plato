/**
 * @Date 2019-05-27 17:12:36
 * @Remark
 */

import { AxiosResponse } from "axios";

// 返回数据包
export interface IData<T> {
  fail: string;
  err: string;
  payload: T | null; // 最后返回和处理过的数据容器
}

export const BLANK_RESPONSE: AxiosResponse<null> = {
  data: null,
  status: 999,
  statusText: "",
  headers: {},
  config: {}
};

export interface IOpenOption {
  long?: boolean | number; // 布尔是默认设置, 数字是特殊设置
  fresh?: boolean;
  static?: boolean;
}
export const openOption: IOpenOption = {
  long: false,
  fresh: false,
  static: false
};

export const CODE_NOT_LOGIN = -1; // 没有登录
export const CODE_SUCCESS = "1999"; // 成功返回
// http成功返回
export const httpOkCode = 200;

// http错误code对应信息
export interface IHttpErrorCodeMap {
  [code: number]: string;
}
export const HTTP_ERROR_CODE_MAP: IHttpErrorCodeMap = {
  // 自定义
  999: "网络出现问题或服务端无响应",
  998: "没有选中上传文件",
  // 标准
  403: "访问被禁止",
  404: "资源不存在",
  405: "不允许此请求方法",
  406: "请求格式不可得",
  415: "服务器不支持参数格式",
  500: "服务器发生错误",
  502: "网关错误",
  503: "服务暂时不可用",
  504: "网关超时"
};
