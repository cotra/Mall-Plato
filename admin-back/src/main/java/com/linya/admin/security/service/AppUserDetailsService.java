package com.linya.admin.security.service;

import com.linya.admin.dao.UmsAdminDao;
import com.linya.admin.modules.exception.DefaultExceptionHandler;
import com.linya.admin.po.UmsAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Autowired
    UmsAdminDao umsAdminDao;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        LOGGER.info("AppUserDetailsService load id: " + id);
        long idLong = Long.parseLong(id);
        List<UmsAdmin> list = umsAdminDao.getListById(idLong);
        if(list.size() == 0 || list == null || list.size() != 1) {
            throw new BadCredentialsException("用户或密码错误");
        }
        UmsAdmin admin = list.get(0);
        if(admin.getStatus() == 0) {
            throw new LockedException("该用户已被锁定");
        }

        AppUserDetails details = new AppUserDetails(id, "{noop}" + admin.getUsername());
        return details;
    }
}