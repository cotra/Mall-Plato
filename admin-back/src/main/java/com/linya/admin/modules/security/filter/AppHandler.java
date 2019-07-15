package com.linya.admin.modules.security.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppHandler extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = getAuthentication(req);
        // 设置对比项
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(authentication);
        // 继续
        filterChain.doFilter(req, res);
    }

    // 认证实现
    private Authentication getAuthentication(HttpServletRequest req) {
        return new UsernamePasswordAuthenticationToken("admin", "123456");
    }
}
