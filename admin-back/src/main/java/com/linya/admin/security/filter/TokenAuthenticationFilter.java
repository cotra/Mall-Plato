package com.linya.admin.security.filter;

import com.linya.admin.bo.TokenBo;
import com.linya.admin.config.CoreConfig;
import com.linya.admin.dao.UmsAdminDao;
import com.linya.admin.modules.exception.DefaultExceptionHandler;
import com.linya.admin.po.UmsAdmin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Autowired
    CoreConfig coreConfig;

    @Autowired
    TokenBo tokenBo;

    @Autowired
    UmsAdminDao umsAdminDao;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String header = req.getHeader(coreConfig.getJWT_HEADER());
        LOGGER.info("Token Arrivals: " + header);
        if(header != null && !header.isEmpty()) {
            Jws<Claims> jws;
            try {
                jws = tokenBo.validate(header);
                Claims jwsBody = jws.getBody();
                // 需要数据
                Integer id = (Integer) jwsBody.get("id");
                Date issuedAt = jwsBody.getIssuedAt();
                Date expiration = jwsBody.getExpiration();

                List<UmsAdmin> list = umsAdminDao.getListById(id.longValue());
                if(list.size() == 0 || list == null || list.size() != 1) {
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无凭据对应用户");
                }
                UmsAdmin admin = list.get(0);
                if(issuedAt.getTime() != admin.getLoginTime().getTime()) {
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "用户已重新登录,请使用最新凭据");
                }
                if(new Date().getTime() > expiration.getTime()) {
                    res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "凭据已经过期失效");
                }
                // 设置对比项
                SecurityContext context = SecurityContextHolder.getContext();
                if(context.getAuthentication() == null) {
                    context.setAuthentication(new UsernamePasswordAuthenticationToken(id.longValue(), id.longValue()));
                }
            } catch (JwtException e) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "非法凭据，无法解析");
            }
        }
        filterChain.doFilter(req, res);
    }
}
