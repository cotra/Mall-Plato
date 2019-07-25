/**
 * @Title api
 * @Date 2019-05-28 10:40:15
 * @Remark
 */

import { IApi, IRes } from "api/core";

export const API_UPGRADE_VERSION: IApi = {
  title: "版本信息",
  path: "version.json",
  method: "GET",
  prefix: ""
};

// res
export type IResUpgradeVersion = IRes<IDataUpgradeVersion>;

export interface IDataUpgradeVersion {
  latestVersion: string;
  time: string;
  desc: string[];
  todo: string[];
}
