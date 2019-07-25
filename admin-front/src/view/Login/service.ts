/**
 * @Date 2019-05-25 14:41:18
 * @Remark
 */

// lib
// config
// script & methods & public
// http
import { IData } from "http/model";
import { open, bag, isOkRes } from "http/v1";
// api
import { API_LOGIN, IReqLogin, IResLogin } from "api/ums/authorize/login";
import { API_MY_INFO } from "api/ums/authorize/info";
// interface && type && class
import { IAccount } from "model/account";
// 其它

// 登录
export async function loginService(params: IReqLogin) {
  // 开始前
  // 打开接口
  const a1 = await open<IReqLogin, IResLogin>(API_LOGIN, params);
  // 创建返回数据
  const data = bag<string>([a1]);
  // 成功后处理
  if (isOkRes(a1)) {
    data.payload = a1.data;
  }
  // 返回
  return data;
}

// 获取用户信息
export async function getMyInfoService(params: IReqLogin) {
  // 开始前
  // 打开接口
  const a1 = await open<{}, any>(API_MY_INFO, {});
  // 创建返回数据
  const data = bag<IAccount>([a1]);
  // 成功后处理
  if (isOkRes(a1)) {
    // const a1Format = formatResData<any>(a1.data);
    // data.payload = createAccount(a1Format, params);
  }
  // 特殊处理

  // 返回
  return data;
}

// function createAccount(data: IDataMyInfo, params: IReqLogin): IAccount {
//   const accessMenu: IMenu[] = data.menuList.map(el => {
//     return {
//       id: el.id,
//       code: el.menuCode,
//       icon: el.menuIcon,
//       name: el.menuName,
//       url: el.menuUrl,
//       parentId: el.pId === "" ? null : parseInt(el.pId, 10)
//     };
//   });
//   const permission: IPermission[] = data.permissionList.map(el => {
//     return {
//       id: el.id,
//       name: el.name,
//       permission: el.permission,
//       url: el.url,
//       desc: el.description
//     };
//   });
//   const result: IAccount = {
//     id: 99999, // 后台没有返回id
//     name: params.userName,
//     nickname: data.name,
//     avatar: data.headUrl
//   };

//   return result;
// }
