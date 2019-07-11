package com.linya.admin.ums.auth;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.ums.UmsApiUrl;
import com.linya.admin.ums.auth.dto.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = UmsApiUrl.AUTH)
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("login")
    public Api<String> login(@RequestBody @Validated LoginReq req) {
        Cstp<String> cstp = service.login(req);
        if(cstp.isOk()) {
            return Sender.ok("登录成功", null);
        } else if (cstp.getFlag().equals(service.ACCOUNT_ONLINE)) {
            return Sender.fail("账号已经登录", null);
        } else if(cstp.getFlag().equals(service.ACCOUNT_FAIL)) {
            return Sender.fail("账号或密码错误", null);
        } else if(cstp.getFlag().equals(service.ACCOUNT_LOCKED)) {
            return Sender.fail("该账号已被锁定", null);
        } else {
            return Sender.fail("登录失败", null);
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
