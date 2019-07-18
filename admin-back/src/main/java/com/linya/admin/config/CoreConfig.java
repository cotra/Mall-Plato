package com.linya.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:core/config.properties")
public class CoreConfig {

    @Value("${jwt.key}")
    private String JWT_KEY;

    @Value("${jwt.iss}")
    private String JWT_ISS;

    @Value("${jwt.exp}")
    private Integer JWT_EXP;

    public Integer getJWT_EXP() {
        return JWT_EXP;
    }

    public String getJWT_KEY() {
        return JWT_KEY;
    }

    public String getJWT_ISS() {
        return JWT_ISS;
    }
}
