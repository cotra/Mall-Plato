/**
 * @Date 2019-05-27 10:29:39
 * @Remark
 */

// lib
import store from "store";
import { encrypt, decrypt } from "utils/encryptUtils";
import log from "utils/logUtils";
// list
import {
  localStorageMenu,
  localStorageAccount,
  localStorageVersion,
  localStorageLocalSetting
} from "./name";

export const LOCAL_STORAGE_MENU = localStorageMenu;
export const LOCAL_STORAGE_ACCOUNT = localStorageAccount;
export const LOCAL_STORAGE_VERSION = localStorageVersion;
export const LOCAL_STORAGE_LOCAL_SETTING = localStorageLocalSetting;

// ----------------------------------------------------------------
function getStoreName(name: string) {
  return `_${name}_`;
}

/**
 * 尝试保存本地数据,错误的话返回false
 */
export function setStore<T>(
  name: string,
  data: T,
  encryption: boolean = false
): boolean {
  const dataName = getStoreName(name);
  try {
    const save = encryption ? encrypt(data) : JSON.stringify(data);
    store.set(dataName, save);
    return true;
  } catch (error) {
    log.error(error, "setStore");
    return false;
  }
}

/**
 * 尝试读取本地数据,没有或错误的话返回null
 */
export function getStore<T>(
  name: string,
  encryption: boolean = false
): T | null {
  const dataName = getStoreName(name);
  try {
    const data = store.get(dataName);
    if (data) {
      const result: T = encryption ? decrypt(data) : JSON.parse(data);
      return result;
    }
    return null;
  } catch (error) {
    log.error(error, "getStore");
    return null;
  }
}

/**
 * 删除某一个cookie值
 */
export function removeStore(name: string): void {
  const dataName = getStoreName(name);
  store.remove(dataName);
}

/**
 * 删除所有cookie值
 */
export function clearStore(): void {
  store.each((value, key) => {
    store.remove(key);
  });
}
