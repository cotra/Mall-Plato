/**
 * @Date 2019-05-27 10:42:35
 * @Remark
 */

import { isProdMode } from "config/env";

// console对象
const CONSOLE: Console = console;

function createTitle(flag: string) {
  return `|${flag}|`;
}

/**
 * console.info
 * @param msg 数据
 */
function info(msg: any, flag: string = "info", show: boolean = true) {
  const title = createTitle(flag);
  if (!isProdMode() && show) {
    CONSOLE.info(title, msg);
  }
  return flag;
}

/**
 * console.warn
 * @param msg 数据
 */
function warn(msg: any, flag: string = "warn", show: boolean = true) {
  const title = createTitle(flag);
  if (!isProdMode() && show) {
    CONSOLE.warn(title, msg);
  }
  return flag;
}

/**
 * console.error
 * @param msg 数据
 */
function error(msg: any, flag: string = "error", show: boolean = true) {
  const title = createTitle(flag);
  if (!isProdMode() && show) {
    CONSOLE.error(title, msg);
  }
  return flag;
}

export default {
  info,
  warn,
  error,
  console: CONSOLE
};
