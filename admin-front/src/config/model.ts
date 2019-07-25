/**
 * @Date 2019-07-24 17:40:02
 * @Remark
 */

export type IAppMode = "DEV" | "PROD" | "BETA";

export const APP_MODE_MAP: {
  [mode: string]: IAppMode;
} = {
  DEV: "DEV", // 开发环境
  PROD: "PROD", // 生产环境
  BETA: "BETA" // 测试环境
};

export interface IServer {
  apiServer: string;
  webSocketServer: string;
  mediaServer: string;
  prefix: string;
}
