/**
 * @Date 2019-05-11 10:38:10
 * @Remark
 */

// react
import React, { Component } from "react";
import { RouteComponentProps, Redirect } from "react-router-dom";
// lib
import { Layout, BackTop } from "antd";
// components & widget
import AdminHeader from "./AdminHeader";
import Menu from "./AdminMenu";
import RoutesAdmin from "routes/Admin";
import VersionModal from "./VersionModal";
import Drawer from "./Drawer";
// style
import le from "./page.module.less";
// config
import { APP_VERSION } from "config/env";
// script & methods & public
// store
import { observer } from "mobx-react";
import { state } from "./state";
import accountSAO from "state/sao/account.sao";
// controller
import { getUpgradeVersion } from "./controller";
// interface && type && class
import { ClickParam } from "antd/lib/menu";
// 其它

const { Content } = Layout;
const { Sider } = Layout;

interface IProps extends RouteComponentProps<any> {}
// class
@observer
class Admin extends Component<IProps> {
  public componentDidMount() {
    this.setMenu(this.props);
    getUpgradeVersion();
  }
  public render() {
    // props && state
    const { collapsed } = state;

    const login = accountSAO.isLogin();

    if (!login) {
      return <Redirect to="/login" />;
    }

    return (
      <Layout className="admin-view">
        <Sider trigger={null} breakpoint="lg" collapsed={collapsed}>
          <div className={le.siderHeader}>
            {!collapsed && <span>{APP_VERSION}</span>}
          </div>
          <Menu onClick={this.menuClick} onOpenChange={this.openMenu} />
        </Sider>
        <Layout>
          <AdminHeader onClick={this.trigger} />
          <Content className="admin-main">
            <RoutesAdmin />
          </Content>
        </Layout>
        <VersionModal />
        <Drawer />
        <BackTop visibilityHeight={100} />
      </Layout>
    );
  }
  private trigger = () => {
    const before: boolean = state.collapsed;
    // 关闭时取消打开的菜单
    if (!state.collapsed) {
      state.openSetter([]);
    }
    state.collapsedChange();
    // 打开时设置菜单
    if (before && !state.collapsed) {
      this.setMenu(this.props);
    }
  };
  private setMenu = (props: IProps) => {
    const pathname: string = props.location.pathname;
    const arr: string[] = pathname.split("/");

    state.menuSetter([pathname]);

    if (arr.length > 3) {
      const open: string = pathname.substr(0, pathname.lastIndexOf("/"));
      state.openSetter([open]);
    } else {
      state.openSetter([]);
    }
  };
  private menuClick = (param: ClickParam) => {
    if (this.props.location.pathname !== param.key) {
      state.menuSetter([param.key]);
    }
  };
  private openMenu = (params: string[]) => {
    state.openSetter(params);
  };
}

export default Admin;
