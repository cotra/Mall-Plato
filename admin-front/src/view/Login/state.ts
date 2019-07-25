/**
 * @Date 2019-05-13 17:30:35
 * @Remark
 */

// lib
import { observable, action } from "mobx";
// script & methods & public
// controller
import { IState } from "./controller";
// interface && type && class
// 其它

class State implements IState {
  // state
  @observable public loading = false;
  // Setter
  @action.bound
  public loadingSetter(status: boolean) {
    this.loading = status;
  }
}

export const state = new State();
