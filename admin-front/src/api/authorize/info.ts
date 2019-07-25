/**
 * @Title api
 * @Date 2019-05-28 10:40:15
 * @Remark
 */

import { IApi, IRes } from "api/core";

export const API_MY_INFO: IApi = {
  title: "当前用户信息",
  path: "user/getUserInfo",
  method: "GET",
  prefix: "api"
};

// req
// none

// res
export interface IResMyInfo extends IRes {
  data: any;
}
