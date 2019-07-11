package com.linya.admin.ums.auth;

import com.linya.admin.bo.AuthBo;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.ums.auth.dto.LoginReq;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    /**
     * 登录
     */
    public Cstp<String> login(LoginReq req) {
        Subject subject = SecurityUtils.getSubject();
        // 密码处理
        try {
            subject.login(new UsernamePasswordToken(req.getUsername(), AuthBo.passwordToMd5Hash(req.getPassword())));
            return Result.ok();
        } catch (AuthenticationException e) {
            System.out.println("-----------------------------");
            return Result.fail();
        }
    }

    /**
     * 注销
     */
    public Cstp<String> logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return Result.ok();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Result.fail();
        }
    }
}
