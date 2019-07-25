/**
 * @Date 2019-05-13 17:15:24
 * @Remark
 */

// lib
import { toJS } from "mobx";
// script & methods & public
import { setStore, LOCAL_STORAGE_ACCOUNT } from "public/storage";
// store state
import { user } from "state";
// interface && type && class
import { IAccount } from "model/account";
// 其它

const accountSAO = {
  // Setter
  accountSetter(payload: IAccount) {
    user.accountSetter(payload);
    // 持久化
    setStore(LOCAL_STORAGE_ACCOUNT, payload, true);
  },
  accountValueSetter(payload: Partial<IAccount>) {
    user.accountValueSetter(payload);
    // 持久化
    setStore(LOCAL_STORAGE_ACCOUNT, this.accountGetter(), true);
  },
  // Getter
  accountGetter() {
    return toJS(user.account);
  },
  //
  isLogin() {
    return user.isLogin;
  }
};

export default accountSAO;
