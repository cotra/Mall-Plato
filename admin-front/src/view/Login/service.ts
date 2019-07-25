/**
 * @Date 2019-05-25 14:41:18
 * @Remark
 */

// lib
// config
// script & methods & public
// http
import { open, bag, isOkRes } from "http/v1";
// api
import { API_LOGIN, IReqLogin, IResLogin } from "api/ums/authorize/login";
// interface && type && class
import { IAccount } from "model/account";
// 其它

// 登录
export async function loginService(params: IReqLogin) {
  // 开始前
  // 打开接口
  const a1 = await open<IReqLogin, IResLogin>(API_LOGIN, params);
  // 创建返回数据
  const data = bag<IAccount>([a1]);
  // 成功后处理
  if (isOkRes(a1)) {
    data.payload = a1.data;
  }
  // 返回
  return data;
}
