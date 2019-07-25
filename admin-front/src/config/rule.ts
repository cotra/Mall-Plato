/**
 * @Date 2019-05-28 18:00:45
 * @Remark
 */

export const REQUIRED_RULE = (name: string) => ({
  required: true,
  message: `${name}是必填项`
});

export const MIN_MAX_RULE = (min: number, max: number) => ({
  min,
  max,
  message: `${min}至${max}个字符之间`
});

export const INPUT_REQUIRED_RULE = REQUIRED_RULE("该字段");
export const NAME_LENGTH_RULE = MIN_MAX_RULE(1, 30);
export const PWD_LENGTH_RULE = MIN_MAX_RULE(6, 30);
export const VIN_LENGTH_RULE = MIN_MAX_RULE(1, 17);
export const CODE_LENGTH_RULE = MIN_MAX_RULE(3, 50);
export const DESC_LENGTH_RULE = MIN_MAX_RULE(1, 100);
