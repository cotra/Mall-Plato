/**
 * @Date 2019-05-30 10:32:23
 * @Remark
 */

// lib
import { toJS } from "mobx";
// script & methods & public
import { setStore, LOCAL_STORAGE_MENU } from "public/storage";
// store state
import { user } from "state";
// interface && type && class
import { IMenuRoute } from "routes/menus";
// 其它

const userSAO = {
  // Setter
  menuSetter(payload: IMenuRoute[]) {
    user.menuSetter(payload);
    // 持久化
    setStore(LOCAL_STORAGE_MENU, payload);
  },
  // Getter
  menuGetter() {
    return toJS(user.menu);
  }
};

export default userSAO;
