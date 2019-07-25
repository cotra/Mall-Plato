/**
 * @Date 2019-07-24 17:25:18
 * @Remark
 */

// react
import React from "react";
import ReactDOM from "react-dom";
// lib
import { LocaleProvider } from "antd";
import zhCN from "antd/lib/locale-provider/zh_CN";
import "moment/locale/zh-cn";
// components & widget
import Bootstrap from "./Bootstrap";
// style
import "./styles/Yelena.less";
// config
// script & methods & public
// interface && type
// 其它
import * as serviceWorker from "./serviceWorker";

// 根渲染函数
function render(Component: React.FC): void {
  // 渲染根节点
  ReactDOM.render(
    <LocaleProvider locale={zhCN}>
      <Component />
    </LocaleProvider>,
    document.getElementById("root") as HTMLElement
  );
}

render(Bootstrap);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();