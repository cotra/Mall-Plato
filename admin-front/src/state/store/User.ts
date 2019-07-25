/**
 * @Date 2019-05-13 17:10:40
 * @Remark
 */

// lib
import { observable, action, computed } from "mobx";
// config
// script & methods & public
import {
  getStore,
  LOCAL_STORAGE_MENU,
  LOCAL_STORAGE_ACCOUNT
} from "public/storage";
// interface && type
import { IAccount, BLANK_ACCOUNT } from "model/account";
import { IMenuRoute } from "routes/menus";
// 其它

interface IUser {
  account: IAccount;
  menu: IMenuRoute[];
}

class User implements IUser {
  // state
  @observable public account: IAccount = BLANK_ACCOUNT;
  @observable public menu: IMenuRoute[] = [];
  constructor() {
    const account = getStore<IAccount>(LOCAL_STORAGE_ACCOUNT, true);
    if (account) {
      this.accountSetter(account);
    }
    const menus = getStore<IMenuRoute[]>(LOCAL_STORAGE_MENU);
    if (menus) {
      this.menuSetter(menus);
    }
  }
  // set
  @action.bound
  public menuSetter(value: IMenuRoute[]) {
    this.menu = value;
  }
  @action.bound
  public accountSetter(value: IAccount) {
    this.account = value;
  }
  @action.bound
  public accountValueSetter(value: Partial<IAccount>) {
    this.account = {
      ...this.account,
      ...value
    };
  }
  // computed
  @computed get isLogin() {
    return this.account.id > 0;
  }
}

export default User;
