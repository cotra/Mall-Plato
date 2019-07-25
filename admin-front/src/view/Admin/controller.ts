/**
 * @Date 2019-05-28 14:25:56
 * @Remark
 */

// lib
// config
// script & methods & public
import toast from "public/toast";
import { getStore, LOCAL_STORAGE_VERSION, setStore } from "public/storage";
// store
import { state } from "./state";
// service
import { getUpgradeVersionService } from "./service";
// interface && type && class
import { IDataUpgradeVersion } from "api/upgrade/version";
// 其它

export interface IState {
  collapsed: boolean;
  menu: string[];
  open: string[];
  // showDrawer
  drawer: boolean;
  // 全屏
  full: boolean;
  // 修改密码
  pwdModal: boolean;
  pwdLoading: boolean;
  // 修改个人信息
  infoModal: boolean;
  infoLoading: boolean;
  // 版本升级
  versionModal: IDataUpgradeVersion | null;
}

// 版本信息
export async function getUpgradeVersion() {
  // 开始前
  // 调用服务
  const result = await getUpgradeVersionService();
  // 结束后
  // 成功
  if (result.payload) {
    const version = getStore<string>(LOCAL_STORAGE_VERSION);
    if ((version && version !== result.payload.latestVersion) || !version) {
      state.versionModalSetter(result.payload);
    }
  }
  // 失败和异常
  toast.whenFailOrErr(result);
}

export function know() {
  const info = state.versionModalGetter();
  if (info) {
    setStore(LOCAL_STORAGE_VERSION, info.latestVersion);
  }
  state.versionModalSetter(null);
}
