/**
 * @Date 2019-05-11 14:30:50
 * @Remark
 */

export interface IMenuRoute {
  title: string;
  icon: string;
  code: string;
  path: string;
  sub: IMenuRoute[];
}

export const MENU_PREFIX = "menus";

function addPrefix(params: string) {
  return `${MENU_PREFIX}:${params}`;
}

export const menus: IMenuRoute[] = [
  {
    title: "Dashboard",
    icon: "dashboard",
    code: addPrefix("dashboard"),
    path: "/admin",
    sub: []
  },
  {
    title: "系统管理",
    icon: "setting",
    code: addPrefix("system"),
    path: "/admin/system",
    sub: [
      {
        title: "用户管理",
        icon: "",
        code: addPrefix("system:user"),
        path: "/admin/system/user",
        sub: []
      },
      {
        title: "角色管理",
        icon: "",
        code: addPrefix("system:role"),
        path: "/admin/system/role",
        sub: []
      },
      {
        title: "权限管理",
        icon: "",
        code: addPrefix("system:permission"),
        path: "/admin/system/permission",
        sub: []
      },
      {
        title: "菜单管理",
        icon: "",
        code: addPrefix("system:menu"),
        path: "/admin/system/menu",
        sub: []
      },
      {
        title: "系统设置",
        icon: "",
        code: addPrefix("system:setting"),
        path: "/admin/system/setting",
        sub: []
      }
    ]
  }
];
