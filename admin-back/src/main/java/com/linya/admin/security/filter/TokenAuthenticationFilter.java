package com.linya.admin.security.filter;

import com.linya.admin.config.CoreConfig;
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

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    CoreConfig coreConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String header = req.getHeader(coreConfig.getJWT_HEADER());
        if (header != null && !header.isEmpty()) {
            // 设置对比项
            SecurityContext context = SecurityContextHolder.getContext();
            if (context.getAuthentication() == null) {
                context.setAuthentication(new UsernamePasswordAuthenticationToken(header, ""));
            }
        }
        filterChain.doFilter(req, res);
    }
}
