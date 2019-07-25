/**
 * @Date 2019-05-27 09:55:02
 * @Remark
 */

// date-fns
import format from "date-fns/format";
import get_time from "date-fns/get_time";
import add_days from "date-fns/add_days";
import moment, { Moment } from "moment";

// 格式化时间
function formatTime(
  time: Date | string | Moment = new Date(),
  type: 0 | 1 | 2 | 3 = 0
): string {
  let pattern: string = "";
  switch (type) {
    case 0:
      pattern = "YYYY-MM-DD";
      break;
    case 1:
      pattern = "YYYY-MM-DD HH:mm:ss";
      break;
    case 2:
      pattern = "YYYY-MM";
      break;
    case 3:
      pattern = "YYYY";
      break;
    default:
      pattern = "YYYY-MM-DD";
      break;
  }
  // 如果是moment
  if (moment.isMoment(time)) {
    const temp = time.toDate();
    return format(temp, pattern);
  }
  return format(time, pattern);
}

// 获得时间戳
function getTime(time: Date | string = new Date()): number {
  return get_time(time);
}

// 增加天数
function addDays(days: number): Date {
  return add_days(new Date(), days);
}

export default {
  getTime,
  addDays,
  format: formatTime
};
