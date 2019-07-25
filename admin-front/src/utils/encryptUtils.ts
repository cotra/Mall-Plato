/**
 * @Date 2019-05-13 17:58:16
 * @Remark
 */

// lib
import AES from "crypto-js/aes";
import enc from "crypto-js/enc-utf8";
// config
import { CRYPTO_KEY } from "config/setting";
// interface && type && class
import { WordArray, DecryptedMessage } from "crypto-js";

/**
 * 加密
 */
export function encrypt<T>(data: T): string {
  const bytes: WordArray = AES.encrypt(JSON.stringify(data), CRYPTO_KEY);
  return bytes.toString();
}

/**
 * 解密
 */
export function decrypt<T>(data: string): T {
  const bytes: DecryptedMessage = AES.decrypt(data, CRYPTO_KEY);
  return JSON.parse(enc.stringify(bytes));
}
