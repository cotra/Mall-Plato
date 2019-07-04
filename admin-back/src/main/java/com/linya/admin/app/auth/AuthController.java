package com.linya.admin.app.auth;

import com.linya.admin.api.Api;
import com.linya.admin.api.Result;
import com.linya.admin.config.ApiUrlConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiUrlConfig.AUTH)
public class AuthController {

    @GetMapping("login")
    public Api<String> login() {
        return Result.ok("登录成功");
    }
}
