/**
 * @Title 404
 * @Date 2019-05-13 15:10:57
 * @Remark
 */

// react
import React, { Component } from "react";
// lib
// components & widget
import WarnBox from "components/WarnBox";
// style
// config
// script & methods & public
// store
// controller
// interface && type && class
// 其它

// class
class AdminNotPermission extends Component {
  public render() {
    return (
      <div className="admin-content">
        <WarnBox title="当前账户禁止访问该模块" />
      </div>
    );
  }
}

export default AdminNotPermission;
