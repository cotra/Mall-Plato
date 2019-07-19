package com.linya.admin.security.filter;

import com.linya.admin.bo.TokenBo;
import com.linya.admin.config.CoreConfig;
import com.linya.admin.modules.exception.DefaultExceptionHandler;
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

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Autowired
    CoreConfig coreConfig;

    @Autowired
    TokenBo tokenBo;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String header = req.getHeader(coreConfig.getJWT_HEADER());
        LOGGER.info("Arrivals Token: " + header);
        if (header != null && !header.isEmpty() && header.startsWith(coreConfig.getJWT_HEAD())) {
            try {
                Jws<Claims> jws = tokenBo.validate(header);
                Claims jwsBody = jws.getBody();
                // 需要数据
                Integer id = (Integer) jwsBody.get("id"); // id
                Date issuedAt = jwsBody.getIssuedAt(); // 签发时间
                Date expiration = jwsBody.getExpiration(); // 过期时间
                String audience = jwsBody.getAudience();
                // 设置对比项
                SecurityContext context = SecurityContextHolder.getContext();
                if(context.getAuthentication() == null) {
                    context.setAuthentication(new UsernamePasswordAuthenticationToken(id.longValue(), audience));
                }
            } catch (JwtException e) {
                LOGGER.error("jwt validate error:" + e.getMessage());
            }
        }
        filterChain.doFilter(req, res);
    }
}
