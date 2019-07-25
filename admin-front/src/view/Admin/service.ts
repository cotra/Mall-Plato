/**
 * @Date 2019-05-25 14:41:18
 * @Remark
 */

// lib
// config
// script & methods & public
// http
import { open, bag, isOkRes } from "http/v1";
// api
import {
  API_UPGRADE_VERSION,
  IResUpgradeVersion,
  IDataUpgradeVersion
} from "api/upgrade/version";
// interface && type && class
// 其它

// 版本信息
export async function getUpgradeVersionService() {
  // 开始前
  // 打开接口
  const a1 = await open<{}, IResUpgradeVersion>(
    API_UPGRADE_VERSION,
    {},
    {
      long: false,
      fresh: true,
      static: true
    }
  );
  // 创建返回数据
  const data = bag<IDataUpgradeVersion>([a1]);
  // 成功后处理
  if (isOkRes(a1)) {
    data.payload = a1.data;
  }
  // 特殊处理

  // 返回
  return data;
}
