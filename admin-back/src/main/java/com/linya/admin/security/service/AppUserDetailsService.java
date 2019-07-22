package com.linya.admin.security.service;

import com.linya.admin.bo.TokenBo;
import com.linya.admin.dao.UmsAdminDao;
import com.linya.admin.modules.exception.DefaultExceptionHandler;
import com.linya.admin.po.UmsAdmin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.List;

public class AppUserDetailsService implements UserDetailsService {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Autowired
    UmsAdminDao umsAdminDao;

    @Autowired
    TokenBo tokenBo;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        try {
            Jws<Claims> jws = tokenBo.validate(token);
            Claims jwsBody = jws.getBody();
            // 需要数据
            Integer id = (Integer) jwsBody.get("id"); // id
            Date issuedAt = jwsBody.getIssuedAt(); // 签发时间
            Date expiration = jwsBody.getExpiration(); // 过期时间
            String audience = jwsBody.getAudience(); // 用户名
            System.out.println(issuedAt);
            System.out.println(expiration);
            System.out.println(audience);

            List<UmsAdmin> list = umsAdminDao.getListById(id.longValue());
            if (list.size() == 0 || list == null || list.size() != 1) {
                throw new DisabledException("用户或密码错误");
            }
            UmsAdmin admin = list.get(0); // 要验证的用户
            if (admin.getStatus() == 0) {
                throw new LockedException("该用户已被锁定");
            }
            if(issuedAt.getTime() != admin.getLoginTime().getTime()) {
                throw new BadCredentialsException("用户已重新登录,请使用最新凭据");
            }
            if(new Date().getTime() > expiration.getTime()) {
                throw new CredentialsExpiredException("该凭据已经过期失效");
            }
            AppUserDetails details = new AppUserDetails(token, "{noop}" + "");
            return details;
        } catch (JwtException e) {
            LOGGER.error("jwt validate error:" + e.getMessage());
            throw new BadCredentialsException("无法解析该身份凭据"); // 该错误不应在正常情况下出现
        }
    }
}