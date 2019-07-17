package com.linya.admin.security.handler;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AppLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Api<Object> api = Sender.ok("注销成功", null);
        JSON parse = JSONUtil.parse(api);

        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(parse.toString());
        httpServletResponse.getWriter().flush();
    }
}
