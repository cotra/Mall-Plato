/**
 * @Date 2019-06-04 15:51:05
 * @Remark
 */

// react
import React, { Component, Fragment } from "react";
// lib
import isNull from "lodash/isNull";
import { Modal, Typography, Icon } from "antd";
// components & widget
// style
// config
// script & methods & public
// store
import { observer } from "mobx-react";
import { state } from "./state";
// controller
import { know } from "./controller";
// interface && type && class
// 其它

const { Title, Text } = Typography;

@observer
class InfoModal extends Component<{}> {
  public render() {
    // props && state
    const title = "系统升级信息";
    const info = state.versionModalGetter();
    const show = !isNull(info);

    return (
      <Modal
        title={title}
        visible={show}
        onCancel={this.handleCancel}
        onOk={this.handleOk}
        closable={false}
        cancelText="稍后再看"
        okText="知道了，不再提示"
      >
        <div className="modal-container-full">
          {info && (
            <Fragment>
              <div>
                <Title level={4}>
                  <span>当前系统已升级为：</span>
                  <span className="ml-5">{info.latestVersion}</span>
                  <span className="ml-5">版本</span>
                </Title>
              </div>
              <div className="mt-30">
                <Icon type="clock-circle" />
                <Text className="ml-5">升级时间</Text>
              </div>
              <div className="mt-5">
                <Text className="ml-20">{info.time}</Text>
              </div>
              <div className="mt-10">
                <Icon type="question-circle" />
                <Text className="ml-5">升级了什么?</Text>
              </div>
              <div className="mt-5">
                {info.desc.map((el, index) => {
                  return (
                    <Text key={index} className="ml-20">
                      {index + 1}. {el}
                    </Text>
                  );
                })}
              </div>
              <div className="mt-10">
                <Icon type="warning" />
                <Text className="ml-5">需要做些什么?</Text>
              </div>
              <div className="mt-5">
                {info.todo.map((el, index) => {
                  return (
                    <Text key={index} className="ml-20" type="danger">
                      {index + 1}. {el}
                    </Text>
                  );
                })}
              </div>
            </Fragment>
          )}
        </div>
      </Modal>
    );
  }
  private handleCancel = () => {
    state.versionModalSetter(null);
  };
  private handleOk = () => {
    know();
  };
}

export default InfoModal;
