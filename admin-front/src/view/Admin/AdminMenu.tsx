/**
 * @Date 2019-05-25 18:28:35
 * @Remark
 */

// react
import React, { Component } from "react";
import { Link } from "react-router-dom";
// lib
import { Menu, Icon } from "antd";
// components & widget
// style
// config
// script & methods & public
import { IMenuRoute } from "routes/menus";
// store
import { observer } from "mobx-react";
import { state } from "./state";
import userSAO from "state/sao/user.sao";
// controller
// interface && type && class
import { ClickParam } from "antd/lib/menu";
// 其它

const SubMenu = Menu.SubMenu;

interface IProps {
  onClick: (param: ClickParam) => void;
  onOpenChange: (params: string[]) => void;
}

@observer
class AppMenu extends Component<IProps> {
  public render() {
    // props && state
    const open = state.openGetter();
    const menu = state.menuGetter();
    const menus = userSAO.menuGetter();

    return (
      <Menu
        theme="dark"
        mode="inline"
        openKeys={open}
        selectedKeys={menu}
        {...this.props}
      >
        {this.renderMenuItem(menus)}
      </Menu>
    );
  }
  private renderMenuItem(list: IMenuRoute[]) {
    const result = list.map((el: IMenuRoute) => {
      if (el.sub.length === 0) {
        return (
          <Menu.Item key={el.path}>
            <Link to={el.path}>
              {el.icon ? <Icon type={el.icon} /> : null}
              <span>{el.title}</span>
            </Link>
          </Menu.Item>
        );
      }

      return (
        <SubMenu
          key={el.path}
          title={
            <span>
              {el.icon ? <Icon type={el.icon} /> : null}
              <span>{el.title}</span>
            </span>
          }
        >
          {el.sub.map((item: IMenuRoute) => {
            return (
              <Menu.Item key={item.path}>
                <Link to={item.path}>
                  <span>{item.title}</span>
                </Link>
              </Menu.Item>
            );
          })}
        </SubMenu>
      );
    });

    return result;
  }
}

export default AppMenu;
