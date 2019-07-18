package com.linya.admin.ums.auth;

import com.linya.admin.bo.AuthBo;
import com.linya.admin.bo.TokenBo;
import com.linya.admin.dao.UmsAdminDao;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.po.UmsAdmin;
import com.linya.admin.ums.auth.dao.AuthDao;
import com.linya.admin.ums.auth.dto.LoginReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    TokenBo jwtTokenBo;

    @Autowired
    UmsAdminDao umsAdminDao;

    @Autowired
    AuthBo authBo;

    @Autowired
    AuthDao authDao;

    // 没有该账户
    public static String ACCOUNT_HAVE_NOT = "ACCOUNT_HAVE_NOT";
    // 账户情况异常
    public static String ACCOUNT_ABNORMAL = "ACCOUNT_ABNORMAL";
    // 账户验证失败
    public static String ACCOUNT_FAIL = "ACCOUNT_FAIL";
    // 账户被锁定
    public static String ACCOUNT_LOCKED = "ACCOUNT_LOCKED";

    /**
     * 登录
     */
    public Cstp<String> login(LoginReq req) {
        List<UmsAdmin> list = umsAdminDao.getListByName(req.getUsername());
        if(list.size() == 0 || list == null) {
            return Result.fail(ACCOUNT_HAVE_NOT);
        }
        if(list.size() != 1) {
            return Result.fail(ACCOUNT_ABNORMAL);
        }
        UmsAdmin umsAdmin = list.get(0);
        if(umsAdmin.getStatus() == 0) {
            return Result.fail(ACCOUNT_LOCKED);
        }
        if(!authBo.match(req.getKey(), umsAdmin.getPassword())) {
            return Result.fail(ACCOUNT_FAIL);
        }
        // 验证通过,修改用户登录时间,用该时间生成jwt
        Date lastLoginDate = new Date();
        int result = authDao.updateLoginTime(umsAdmin.getId(), lastLoginDate);
        if(result != 1) {
            return Result.fail(ACCOUNT_FAIL);
        }
        String jwt = jwtTokenBo.generate(umsAdmin.getId(), umsAdmin.getUsername(), lastLoginDate);
        return Result.ok(jwt);
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
