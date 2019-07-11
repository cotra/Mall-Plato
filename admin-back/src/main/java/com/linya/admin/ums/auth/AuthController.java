package com.linya.admin.ums.auth;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.ums.UmsApiUrl;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = UmsApiUrl.AUTH)
public class AuthController {

    @Autowired
    AuthService service;

    @RequiresGuest
    @GetMapping("login")
    public Api<String> login() {
        Cstp<String> cstp = service.login("admin", "1234567");
        if(cstp.isOk()) {
            return Sender.ok("登录成功");
        } else {
            return Sender.ok("用户名或密码错误");
        }
    }

    @GetMapping("logout")
    public Api<String> logout() {
        Cstp<String> cstp = service.logout();
        if(cstp.isOk()) {
            return Sender.ok("注销成功");
        } else {
            return Sender.ok("注销失败");
        }
    }

    @GetMapping("please")
    public Api<String> please() {
        return Sender.fail("请登录");
    }

    @GetMapping("unauthorized")
    public Api<String> unauthorized() {
        return Sender.fail("用户无此权限");
    }
}
