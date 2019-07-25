/**
 * @Date 2019-07-24 16:31:29
 * @Remark
 */

// lib
// config
// script & methods & public
import toast from "public/toast";
import logUtils from "utils/logUtils";
// store
import { state } from "./state";
import accountSAO from "state/sao/account.sao";
// service
import { loginService } from "./service";
// interface && type
import { IReqLogin } from "api/ums/authorize/login";
// 其它

// 表单字段
export interface IForm {
  user: string;
  key: string;
}

// state
export interface IState {
  loading: boolean;
}

export async function login(form: IForm) {
  const params: IReqLogin = {
    username: form.user.trim(),
    key: form.key.trim()
  };
  // 开始前
  state.loadingSetter(true);
  // 调用服务
  const result = await loginService(params);
  // 结束后
  state.loadingSetter(false);
  // 成功
  if (result.payload) {
    logUtils.info(result.payload, "登录账户");
    accountSAO.accountSetter(result.payload);
    // 设置可以访问的菜单
    // setAdminMenu(info.payload.accessMenu);
    // 失败和异常
  }
  // 失败和异常
  toast.whenFailOrErr(result);
}
