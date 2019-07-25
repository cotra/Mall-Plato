/**
 * @Date 2019-07-24 17:38:40
 * @Remark
 */

import { IAppMode, APP_MODE_MAP, IServer } from "./model";

// APP模式
// -----------------------------------------------------------------------
export const APP_MODE = APP_MODE_MAP.DEV; // APP模式
export const APP_VERSION = `0.1.0 ${APP_MODE}`; // 版本号
// -----------------------------------------------------------------------
export function isDevMode() {
  return APP_MODE === APP_MODE_MAP.DEV;
}
export function isProdMode() {
  return APP_MODE === APP_MODE_MAP.PROD;
}
// -----------------------------------------------------------------------

// 开发环境配置
const DEV_SERVER: IServer = {
  apiServer: "",
  webSocketServer: "ws://127.0.0.1:2013",
  mediaServer: "",
  prefix: "api"
};

// 测试环境配置
const BETA_SERVER: IServer = {
  apiServer: "",
  webSocketServer: "ws://127.0.0.1:2013",
  mediaServer: "",
  prefix: "api"
};

// 生产环境配置
const PROD_SERVER: IServer = {
  apiServer: "",
  webSocketServer: "ws://127.0.0.1:2013",
  mediaServer: "",
  prefix: "api"
};

// -----------------------------------------------------------------------
function chooseServer(mode: IAppMode): IServer {
  if (mode === APP_MODE_MAP.BETA) {
    return BETA_SERVER;
  }
  if (mode === APP_MODE_MAP.PROD) {
    return PROD_SERVER;
  }
  return DEV_SERVER;
}
// 返回server配置
export const APP_SERVER: IServer = chooseServer(APP_MODE);
