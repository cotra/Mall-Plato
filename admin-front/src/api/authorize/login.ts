/**
 * @Title api
 * @Date 2019-07-24 16:36:05
 * @Remark
 */

import { IApi, IRes } from "api/core";

export const API_LOGIN: IApi = {
  title: "登录",
  path: "login",
  method: "POST",
  prefix: "api"
};

// req
export interface IReqLogin {
  userName: string;
  password: string;
}

// res
export type IResLogin = IRes;
