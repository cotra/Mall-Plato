/**
 * @Date 2019-05-13 15:41:22
 * @Remark
 */

import { observable, action, toJS } from "mobx";
import Screenfull from "screenfull";
import { IState } from "./controller";
import { IDataUpgradeVersion } from "api/upgrade/version";

class State implements IState {
  // state
  @observable public collapsed = false;
  @observable public menu: string[] = [];
  @observable public open: string[] = [];
  @observable public drawer = false;
  @observable public full = false;
  @observable public pwdModal = false;
  @observable public pwdLoading = false;
  @observable public infoModal = false;
  @observable public infoLoading = false;
  @observable public versionModal: IDataUpgradeVersion | null = null;
  //
  public constructor() {
    if (Screenfull.enabled) {
      this.full = Screenfull.isFullscreen;
    }
  }
  @action.bound
  public collapsedChange() {
    this.collapsed = !this.collapsed;
  }
  @action.bound
  public menuSetter(list: string[]) {
    this.menu = list;
  }
  public menuGetter() {
    return toJS(this.menu);
  }
  @action.bound
  public openSetter(list: string[]) {
    this.open = list;
  }
  public openGetter() {
    return toJS(this.open);
  }
  @action.bound
  public fullSetter(val: boolean) {
    this.full = val;
  }
  @action.bound
  public drawerSetter(val: boolean) {
    this.drawer = val;
  }
  @action.bound
  public pwdModalSetter(val: boolean) {
    this.pwdModal = val;
  }
  @action.bound
  public pwdLoadingSetter(val: boolean) {
    this.pwdLoading = val;
  }
  @action.bound
  public infoModalSetter(val: boolean) {
    this.infoModal = val;
  }
  @action.bound
  public infoLoadingSetter(val: boolean) {
    this.infoLoading = val;
  }
  @action.bound
  public versionModalSetter(val: IDataUpgradeVersion | null) {
    this.versionModal = val;
  }
  public versionModalGetter() {
    return toJS(this.versionModal);
  }
}

export const state = new State();
