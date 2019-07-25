/**
 * @Date 2019-07-24 14:21:52
 * @Remark
 */

// react
import React, { Component } from "react";
import { Route, Switch } from "react-router-dom";
// 路由包装
import AuthRoute from "./AuthRoute";
// 模块 - 仪表盘
import Dashboard from "admin/Dashboard";
// 模块 - 系统管理

class Routes extends Component {
  public render() {
    return (
      <Switch>
        <Route exact={true} path="/admin" component={Dashboard} />
        <AuthRoute />
      </Switch>
    );
  }
}

export default Routes;
