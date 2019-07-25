/**
 * @Date 2019-05-25 13:34:04
 * @Remark 账户
 */

import { IDataLogin } from "api/ums/authorize/login";

export type IAccount = IDataLogin;

export const BLANK_ACCOUNT: IAccount = {
  username: "",
  avatar: "",
  mobile: "",
  email: "",
  nickname: "",
  loginTime: "",
  token: ""
};
