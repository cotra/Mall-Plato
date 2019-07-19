package com.linya.admin.security.service;

import com.linya.admin.modules.exception.DefaultExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LOGGER.info("AppUserDetailsService" + " | " + s);
        AppUserDetails details = new AppUserDetails("3", "{noop}" + "3");

//        throw new UsernameNotFoundException("用户名不存在");
//        throw new LockedException("用户被锁定");
        return details;
    }
}