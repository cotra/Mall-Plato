package com.linya.admin.ums.auth;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.ums.UmsApiUrl;
import com.linya.admin.ums.auth.dto.LoginReq;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = UmsApiUrl.AUTH)
public class AuthController {

    @Autowired
    AuthService service;

    @RequiresGuest
    @PostMapping("login")
    public Api<String> login(@RequestBody @Validated LoginReq req) {
        Cstp<String> cstp = service.login(req);
        if(cstp.isOk()) {
            return Sender.ok("登录成功", null);
        } else {
            return Sender.ok("用户名或密码错误", null);
        }
    }

    @GetMapping("logout")
    public Api<String> logout() {
        Cstp<String> cstp = service.logout();
        if(cstp.isOk()) {
            return Sender.ok("注销成功", null);
        } else {
            return Sender.fail("注销失败", null);
        }
    }

    @GetMapping("please")
    public Api<String> please() {
        return Sender.fail("请登录", null);
    }

    @GetMapping("unauthorized")
    public Api<String> unauthorized() {
        return Sender.fail("用户无此权限", null);
    }
}
