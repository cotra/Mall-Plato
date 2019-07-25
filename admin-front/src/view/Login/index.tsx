/**
 * @Date 2019-07-24 16:31:05
 * @Remark
 */

// react
import React, { Component } from "react";
import { Redirect } from "react-router-dom";
// lib
import { Layout, Card, Form, Button, Input, Icon, Spin } from "antd";
// components & widget
// style
import le from "./page.module.less";
// config
import { APP_VERSION } from "config/env";
import {
  NAME_LENGTH_RULE,
  PWD_LENGTH_RULE,
  INPUT_REQUIRED_RULE
} from "config/rule";
// script & methods & public
// store
import { observer } from "mobx-react";
import { state } from "./state";
// controller
import { IForm, login } from "./controller";
// interface && type
import { FormComponentProps } from "antd/lib/form";
// 其它

const FormItem = Form.Item;

@observer
class Login extends Component<FormComponentProps> {
  public componentWillUnmount() {
    this.props.form.resetFields();
  }
  public render() {
    // props && state
    const { getFieldDecorator } = this.props.form;

    // const account = accountSAO.accountGetter();
    // const isLogin = accountSAO.isLogin();

    // if (isLogin) {
    //   return <Redirect to="/admin" />;
    // }
    return (
      <Spin size="large" spinning={state.loading} delay={50}>
        <Layout className={le.view}>
          <Card bordered={true} className={le.box} hoverable={true}>
            <h1 className={le.logo}>MCMS {APP_VERSION}</h1>
            <Form>
              <FormItem>
                {getFieldDecorator("user", {
                  initialValue: "",
                  rules: [INPUT_REQUIRED_RULE, NAME_LENGTH_RULE]
                })(
                  <Input
                    prefix={<Icon type="user" />}
                    placeholder={"输入用户名称"}
                    maxLength={NAME_LENGTH_RULE.max}
                  />
                )}
              </FormItem>
              <FormItem>
                {getFieldDecorator("key", {
                  initialValue: "",
                  rules: [INPUT_REQUIRED_RULE, PWD_LENGTH_RULE]
                })(
                  <Input.Password
                    prefix={<Icon type="lock" />}
                    placeholder={PWD_LENGTH_RULE.message}
                    maxLength={PWD_LENGTH_RULE.max}
                  />
                )}
              </FormItem>
              <FormItem>
                <Button
                  type="primary"
                  size="large"
                  block={true}
                  className={le.btn}
                  disabled={state.loading}
                  onClick={this.submit}
                >
                  登录
                </Button>
              </FormItem>
            </Form>
            <h6 className={le.version}>
              <span>Copyright © 2019 - 2029</span>
            </h6>
          </Card>
        </Layout>
      </Spin>
    );
  }
  private submit = () => {
    this.props.form.validateFields((err, val: IForm) => {
      // 通过验证
      if (!err) {
        login(val);
      }
    });
  };
}

export default Form.create()(Login);
