package com.linya.admin.ums.auth;

import com.linya.admin.bo.AuthBo;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.ums.auth.dto.LoginReq;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // 账户验证失败
    public static String ACCOUNT_FAIL = "ACCOUNT_FAIL";
    // 账户被锁定
    public static String ACCOUNT_LOCKED = "ACCOUNT_LOCKED";

    /**
     * 登录
     */
    public Cstp<String> login(LoginReq req) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(req.getUsername(), AuthBo.passwordToMd5Hash(req.getPassword())));
            return Result.ok();
        } catch (UnknownAccountException e) {
            return Result.fail(ACCOUNT_FAIL);
        } catch (IncorrectCredentialsException e) {
            return Result.fail(ACCOUNT_FAIL);
        } catch (LockedAccountException e) {
            return Result.fail(ACCOUNT_LOCKED);
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
