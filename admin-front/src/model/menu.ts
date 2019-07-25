/**
 * @Date 2019-05-28 13:51:10
 * @Remark 菜单
 */

export interface IMenu {
  id: number;
  code: string;
  icon: string;
  name: string;
  url: string;
  parentId: number | null;
}
