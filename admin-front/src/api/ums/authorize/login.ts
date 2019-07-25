/**
 * @Date 2019-07-24 16:36:05
 * @Remark
 */

import { IApi, IRes } from "api/core";

export const API_LOGIN: IApi = {
  title: "登录",
  path: "ums/auth/login",
  method: "POST",
  prefix: "api"
};

// req
export interface IReqLogin {
  username: string;
  key: string;
}

// res
export type IResLogin = IRes<IDataLogin>;

// data
export interface IDataLogin {
  username: string;
  avatar: string;
  mobile: string;
  email: string;
  nickname: string;
  loginTime: string;
  token: string;
}
