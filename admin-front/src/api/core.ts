/**
 * @Title http
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
export interface IRes {
  result: number | string;
  msg?: string;
  code?: number;
  message?: string;
}
