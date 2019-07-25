import { string } from "prop-types";

/**
 * @Date 2019-05-25 13:34:04
 * @Remark 账户
 */

// model

export interface IAccount {
  nickname: string;
  avatar: string;
  email: string;
  token: string;
  loginTime: string;
}

export const BLANK_ACCOUNT: IAccount = {
  nickname: "",
  avatar: "",
  email: "",
  token: "",
  loginTime: ""
};
