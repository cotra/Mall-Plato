/**
 * @Date 2019-07-25 15:42:06
 * @Remark
 */

// react
import React, { Component } from "react";
// lib
import { Layout, Menu, Icon, Avatar, Modal } from "antd";
import Screenfull from "screenfull";
// components & widget
// style
import le from "./page.module.less";
// config
// script & methods & public
// store
import { observer } from "mobx-react";
import { state } from "./state";
import accountSAO from "state/sao/account.sao";
// controller
// interface && type
// 其它

const { Header } = Layout;
const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;
const confirm = Modal.confirm;

interface IProps {
  onClick: () => void;
}

@observer
class AdminHeader extends Component<IProps> {
  public render() {
    // props && state
    const account = accountSAO.accountGetter();
    const url = "";

    return (
      <Header className={le.header}>
        <Icon
          className={le.headerTrigger}
          onClick={this.trigger}
          type={state.collapsed ? "menu-unfold" : "menu-fold"}
        />
        <div className={le.headerAction}>
          {state.full ? (
            <Icon
              type="shrink"
              className={le.headerTrigger}
              onClick={this.screenFull}
            />
          ) : (
            <Icon
              type="arrows-alt"
              className={le.headerTrigger}
              onClick={this.screenFull}
            />
          )}
          <Icon
            type="align-right"
            className={le.headerTrigger}
            onClick={this.drawer}
          />
          <Menu mode="horizontal" className={le.headerMenu}>
            <SubMenu
              title={
                url === "" ? (
                  <Avatar
                    className="ant-avatar-fiexed"
                    size="large"
                    icon="user"
                  />
                ) : (
                  <Avatar src={url} />
                )
              }
            >
              <MenuItemGroup title="登录用户">
                <Menu.Item key="welcome">
                  {account.nickname}({account.username})
                </Menu.Item>
              </MenuItemGroup>
              <MenuItemGroup title="系统操作">
                <Menu.Item key="clean" onClick={this.clearLocalData}>
                  <span>清除本地数据</span>
                </Menu.Item>
                <Menu.Item key="pwd" onClick={this.changePwd}>
                  <span>修改登录密码</span>
                </Menu.Item>
                <Menu.Item key="info" onClick={this.changeInfo}>
                  <span>修改我的信息</span>
                </Menu.Item>
                <Menu.Item key="logout" onClick={this.logoutHandle}>
                  <span>退出登录</span>
                </Menu.Item>
              </MenuItemGroup>
            </SubMenu>
          </Menu>
        </div>
      </Header>
    );
  }
  private drawer = () => {
    state.drawerSetter(true);
  };
  private screenFull = () => {
    if (Screenfull.enabled) {
      state.fullSetter(!Screenfull.isFullscreen);
      Screenfull.toggle();
    }
  };
  private changePwd = () => {
    state.pwdModalSetter(true);
  };
  private changeInfo = () => {
    state.infoModalSetter(true);
  };
  private clearLocalData = () => {
    const exit = this.exit;
    confirm({
      title: "清除本地数据的同时会退出系统",
      onOk() {
        exit(true);
      }
    });
  };
  private trigger = () => {
    this.props.onClick();
  };
  private logoutHandle = () => {
    const account = accountSAO.accountGetter();
    const exit = this.exit;
    confirm({
      title: `注销${account.username}退出系统?`,
      onOk() {
        exit(false);
      }
    });
  };
  private exit = (flag: boolean) => {
    // logout(flag);
  };
}

export default AdminHeader;
