package com.linya.admin.security.point;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public static Logger LOGGER = LoggerFactory.getLogger(AppAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
        LOGGER.warn("AuthenticationEntryPoint: " + e.getMessage());

        Api<String> api = Sender.fail("身份凭证认证未通过", e.getMessage());
        JSON parse = JSONUtil.parse(api);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(parse.toString());
        res.getWriter().flush();
    }
}
