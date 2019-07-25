/**
 * @Date 2019-05-28 14:13:22
 * @Remark
 */

// lib
import { message } from "antd";
// config & script & public
// http
import { IData } from "http/model";
// business
// 其它

function msg(text: string) {
  message.info(text);
}

function success(text: string) {
  message.success(text);
}

function warn(text: string) {
  message.warn(text);
}

function error(text: string) {
  message.error(text);
}

// 失败时提示
function whenFailOrErr<T>(result: IData<T>) {
  if (result.fail !== "") {
    message.warn(result.fail);
    return false;
  }
  if (result.err !== "") {
    message.error(result.err);
    return false;
  }
  return true;
}

// 失败时提示
function whenErr<T>(result: IData<T>) {
  if (result.err !== "") {
    message.error(result.err);
    return false;
  }
  return true;
}

export default {
  msg,
  success,
  warn,
  error,
  whenErr,
  whenFailOrErr
};
