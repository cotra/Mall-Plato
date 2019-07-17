package com.linya.admin.security.Point;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Api<Object> api = Sender.fail("身份认证未通过", null);
        JSON parse = JSONUtil.parse(api);

        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(parse.toString());
        httpServletResponse.getWriter().flush();
    }
}
