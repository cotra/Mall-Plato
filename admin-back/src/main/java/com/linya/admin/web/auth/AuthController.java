package com.linya.admin.web.auth;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Result;
import com.linya.admin.config.ApiUrlConfig;
import com.linya.admin.modules.cstp.Cstp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiUrlConfig.AUTH)
public class AuthController {

    @Autowired
    AuthService service;

    @GetMapping("login")
    public Api<String> login() {
        Cstp<String> cstp = service.signIn();
        if(cstp.isOk()) {
            return Result.ok("登录成功");
        } else {
            return Result.ok("登录失败");
        }
    }

    public Api<String> logout() {
        return Result.ok("登录已经注销");
    }

    @GetMapping("please")
    public Api<String> please() {
        return Result.fail("请登录");
    }
}
