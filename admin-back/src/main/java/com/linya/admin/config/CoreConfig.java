package com.linya.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:core/config.properties")
public class CoreConfig {

    @Value("${jwt.header}")
    private String JWT_HEADER;

    @Value("${jwt.head}")
    private String JWT_HEAD;

    @Value("${jwt.key}")
    private String JWT_KEY;

    @Value("${jwt.iss}")
    private String JWT_ISS;

    @Value("${jwt.exp}")
    private Integer JWT_EXP;

    public String getJWT_HEADER() {
        return JWT_HEADER;
    }

    public String getJWT_HEAD() {
        return JWT_HEAD;
    }

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
