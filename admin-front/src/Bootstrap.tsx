/**
 * @Date 2019-07-24 11:57:17
 * @Remark
 */

// react
import React from "react";
// lib
import {
  HashRouter as Router,
  Route,
  Switch,
  Redirect
} from "react-router-dom";
// components & widget
import Admin from "view/Admin";
import Login from "view/Login";
import NotFound from "view/NotFound";
// style
// config & script
// store
// public
// controller
// 其它

const Bootstrap: React.FC = (): JSX.Element => {
  const rootRender = () => <Redirect to="/admin" />;
  // 顶层视图
  return (
    <Router>
      <Switch>
        <Route exact={true} path="/" render={rootRender} />
        <Route path="/admin" component={Admin} />
        <Route path="/login" component={Login} />
        <Route component={NotFound} />
      </Switch>
    </Router>
  );
};

export default Bootstrap;
