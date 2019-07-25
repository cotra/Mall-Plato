/**
 * @Date 2019-05-27 16:47:09
 * @Remark
 */

// api
export interface IApi {
  title: string;
  path: string;
  method: "" | "GET" | "POST" | "UPLOAD";
  prefix: "" | "api";
}

// res
export interface IRes<T> {
  code: string | number;
  msg: string;
  data: T;
}

export type IResItem = IRes<any>;
export type IResList = IResItem[];
export type IResError = IRes<null>;
