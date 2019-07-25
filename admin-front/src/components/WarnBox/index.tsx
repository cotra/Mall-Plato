/**
 * @Date 2019-05-31 10:51:14
 * @Remark
 */

// react
import React from "react";
// lib
import { Icon } from "antd";
// components & widget
// style
import le from "./component.module.less";
// config
// script & methods & public
// store
// controller
// interface && type && class
// 其它

interface IProps {
  title: string;
}
const WarnBox = (props: IProps) => {
  return (
    <div className={le.box}>
      <Icon type="warning" className={le.icon} />
      <h6 className={le.title}>{props.title}</h6>
    </div>
  );
};

export default WarnBox;
