/**
 * @Date 2019-05-27 17:06:13
 * @Remark
 */

// axios
import { AxiosError, AxiosResponse } from "axios";
// lib
// config & script & public
import { setUrlWithParams, createInstance } from "../core";
// 其它
import { BLANK_RESPONSE, IOpenOption } from "../model";
import { IRes } from "api/core";

/* get方法 */
export function get<T, D extends IRes>(
  url: string,
  payload: T,
  option: IOpenOption
): Promise<D | IRes> {
  // 请求路径处理参数
  const path: string = setUrlWithParams(url, payload, option.fresh);
  
  // 请求实例
  return createInstance(option)
    .get(path)
    .then((res: AxiosResponse<D>) => {
      return res.data;
    })
    .catch((error: AxiosError) => {
      const res: AxiosResponse<null> = error.response || BLANK_RESPONSE;
      const result: IRes = {
        result: res.status,
        msg: ""
      };
      return result;
    });
}

/* POST方法 */
export function post<T, D extends IRes>(
  url: string,
  payload: T,
  option: IOpenOption
): Promise<D | IRes> {
  // 请求路径
  const path: string = url;

  // 请求实例
  return createInstance(option)
    .post(path, payload)
    .then((res: AxiosResponse<D>) => {
      return res.data;
    })
    .catch((error: AxiosError) => {
      const res: AxiosResponse<null> = error.response || BLANK_RESPONSE;
      const result: IRes = {
        result: res.status,
        msg: ""
      };
      return result;
    });
}
