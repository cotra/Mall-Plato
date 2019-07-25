/**
 * @Date 2019-05-25 21:37:20
 * @Remark https://github.com/pladaria/reconnecting-websocket
 */

// lib
import ReconnectingWebSocket from "reconnecting-websocket";
import { notification } from "antd";
// config
import { isDevMode } from "config/env";
// script & methods & public
// store
// interface && type && class
// 其它

function isSupport(alert: boolean = true) {
  if (WebSocket) {
    return true;
  }
  // 提醒
  if (alert) {
    notification.error({
      message: "功能检测失败",
      description: "浏览器不支持WebSocket,请更新现代浏览器如Chrome."
    });
  }
  return false;
}

function create(url: string) {
  const rws = new ReconnectingWebSocket(url, "", {
    connectionTimeout: 3000,
    maxRetries: 5,
    debug: isDevMode() // 开发模式调试bug
  });
  return rws;
}

export default {
  isSupport,
  create
};
