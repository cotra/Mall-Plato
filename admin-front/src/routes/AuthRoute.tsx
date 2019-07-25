/**
 * @Date 2019-05-25 18:01:13
 * @Remark
 */

import React from "react";
import { Route, RouteProps } from "react-router-dom";
// lib
// store
// view
import AdminNotFound from "view/AdminNotFound";

const AuthRoute = (props?: RouteProps) => {
  // 权限列表
  // const list = accountSAO.accountGetter().accessMenu;
  // // 判断
  // if (props && props.path && isString(props.path)) {
  //   const route = find(list, { url: props.path });
  //   if (route) {
  //     return <Route {...props} />;
  //   }
  //   return <Route component={AdminNotPermission} />;
  // }

  return <Route component={AdminNotFound} />;
};

export default AuthRoute;
