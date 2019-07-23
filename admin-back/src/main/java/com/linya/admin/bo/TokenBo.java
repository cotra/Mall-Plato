package com.linya.admin.bo;

import cn.hutool.core.date.DateUtil;
import com.linya.admin.config.CoreConfig;
import com.linya.admin.modules.exception.DefaultExceptionHandler;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Component
public class TokenBo {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Autowired
    CoreConfig coreConfig;

    private byte[] getKeyBytes(String key) {
        return key.getBytes();
    }

    private String getKeyString(SecretKey key) {
        return new String(key.getEncoded());
    }

    // 生成jws
    public String generate(Long id, String aud, Date date) {
        byte[] keyBytes = getKeyBytes(coreConfig.getJWT_KEY());
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        // 添加自定义数据
        // TODO 进行数据加密
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);

        JwtBuilder jws = Jwts.builder()
                .setClaims(map)
                .setIssuer(coreConfig.getJWT_ISS())
                .setAudience(aud)
                .setIssuedAt(date)
                .setExpiration(DateUtil.offsetDay(date, coreConfig.getJWT_EXP()));
        // 合成字符串
        String jwt = coreConfig.getJWT_HEAD() + " " + jws.signWith(key).compact();
        LOGGER.info("生成jwt: " + jwt);
        return jwt;
    }

    // 效验和返回
    public Jws<Claims> validate(String token) throws JwtException {
        if(token.startsWith(coreConfig.getJWT_HEAD())) {
            try {
                Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getKeyBytes(coreConfig.getJWT_KEY())).parseClaimsJws(token.replace("Bearer ",""));
                return claimsJws;
            } catch (JwtException e) {
                throw new JwtException("Invalid Token. " + e.getMessage());
            }
        } else {
            throw new JwtException("Invalid Token. " + "非法抬头");
        }
    }
}
