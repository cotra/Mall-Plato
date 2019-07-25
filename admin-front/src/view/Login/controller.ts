/**
 * @Date 2019-07-24 16:31:29
 * @Remark
 */

// lib
// config
// script & methods & public
import toast from "public/toast";
// store
import { state } from "./state";
// service
import {
  loginService,
  getMyInfoService
} from "./service";
// interface && type
import { IReqLogin } from "api/authorize/login";
// 其它

// 表单字段
export interface IForm {
  key: string;
  pwd: string;
}

// state
export interface IState {
  loading: boolean;
}

export async function login(form: IForm) {
  const params: IReqLogin = {
    userName: form.key.trim(),
    password: form.pwd.trim()
  };
  // 开始前
  state.loadingSetter(true);
  // 调用服务
  const result = await loginService(params);
  // 结束后
  state.loadingSetter(false);
  // 成功
  if (result.payload) {
    state.loadingSetter(true);
    const info = await getMyInfoService(params);
    state.loadingSetter(false);
    if (info.payload) {
      // 设置可以访问的菜单
      // setAdminMenu(info.payload.accessMenu);
      // // 获取拓展信息
      // state.loadingSetter(true);
      // const infoExtend = await getMyInfoExtendService(info.payload);
      // state.loadingSetter(false);
      // if (infoExtend.payload) {
      //   // 设置账户信息跳转
      //   log.info(infoExtend.payload, "登录账户");
      //   accountSAO.accountSetter(infoExtend.payload);
      // }
      // toast.whenFailOrErr(infoExtend);
    }
    // 失败和异常
    toast.whenFailOrErr(info);
  }
  // 失败和异常
  toast.whenFailOrErr(result);
}