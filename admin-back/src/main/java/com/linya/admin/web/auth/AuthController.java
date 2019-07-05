package com.linya.admin.web.auth;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Result;
import com.linya.admin.config.ApiUrlConfig;
import com.linya.admin.modules.cstp.Cstp;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiUrlConfig.AUTH)
public class AuthController {

    @Autowired
    AuthService service;

    @RequiresGuest
    @GetMapping("login")
    public Api<String> login() {
        Cstp<String> cstp = service.login("admin", "1234567");
        if(cstp.isOk()) {
            return Result.ok("登录成功");
        } else {
            return Result.ok("用户名或密码错误");
        }
    }

    @GetMapping("logout")
    public Api<String> logout() {
        Cstp<String> cstp = service.logout();
        if(cstp.isOk()) {
            return Result.ok("注销成功");
        } else {
            return Result.ok("注销失败");
        }
    }

    @GetMapping("please")
    public Api<String> please() {
        return Result.fail("请登录");
    }

    @GetMapping("unauthorized")
    public Api<String> unauthorized() {
        return Result.fail("用户无此权限");
    }
}
