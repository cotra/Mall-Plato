/**
 * @Date 2019-05-11 13:38:06
 * @Remark
 */

// react
import React, { Component } from "react";
// lib
import { Drawer } from "antd";
// components & widget
// style
import le from "./page.module.less";
// config
// script & methods & public
// store
import { observer } from "mobx-react";
import { state } from "./state";
// controller
// interface && type && class
// 其它

@observer
class AdminHeader extends Component {
  public componentDidMount() {
    //
  }
  public render() {
    // props && state

    return (
      <Drawer
        title="系统本地设置"
        placement="right"
        closable={false}
        destroyOnClose={true}
        onClose={this.onClose}
        visible={state.drawer}
      >
        <div className={le.drawerRow}>
          <span>连接电话</span>
        </div>
      </Drawer>
    );
  }
  private onClose = () => {
    state.drawerSetter(false);
  };
}

export default AdminHeader;
