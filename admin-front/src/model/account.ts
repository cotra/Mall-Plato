/**
 * @Date 2019-05-25 13:34:04
 * @Remark 账户
 */

// model

export interface IAccount {
  id: number;
  name: string; // user_name
  nickname: string;
  avatar: string;
}

export const BLANK_ACCOUNT: IAccount = {
  id: -1,
  name: "",
  nickname: "",
  avatar: ""
};
