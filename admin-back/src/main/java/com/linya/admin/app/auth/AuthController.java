package com.linya.admin.app.auth;

import com.linya.admin.api.Api;
import com.linya.admin.api.Result;
import com.linya.admin.config.ApiUrlConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiUrlConfig.AUTH)
public class AuthController {

    @GetMapping("login")
    public Api<String> login() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("user123", "1234526"));
            return Result.ok("登录成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Result.fail("登录失败");
        }

    }

    @GetMapping("please")
    public Api<String> please() {
        return Result.fail("请登录");
    }
}
