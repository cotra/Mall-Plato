package com.linya.admin.ums.auth;

import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.ums.auth.dto.LoginReq;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // 账户已经登录
    public static String ACCOUNT_ONLINE = "ACCOUNT_ONLINE";
    // 账户验证失败
    public static String ACCOUNT_FAIL = "ACCOUNT_FAIL";
    // 账户被锁定
    public static String ACCOUNT_LOCKED = "ACCOUNT_LOCKED";

    /**
     * 登录
     */
    public Cstp<String> login(LoginReq req) {
//        Subject subject = SecurityUtils.getSubject();
//
//        if(subject.isAuthenticated()) {
//            return Result.fail(ACCOUNT_ONLINE);
//        }
//        try {
//            subject.login(new UsernamePasswordToken(req.getUsername(), AuthBo.passwordToMd5Hash(req.getPassword())));
//            return Result.ok();
//        } catch (UnknownAccountException e) {
//            return Result.fail(ACCOUNT_FAIL);
//        } catch (IncorrectCredentialsException e) {
//            return Result.fail(ACCOUNT_FAIL);
//        } catch (LockedAccountException e) {
//            return Result.fail(ACCOUNT_LOCKED);
//        }
        return Result.ok();
    }

    /**
     * 注销
     */
    public Cstp<String> logout() {
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.logout();
//            return Result.ok();
//        } catch (AuthenticationException e) {
//            return Result.fail();
//        }
        return Result.fail();
    }
}
