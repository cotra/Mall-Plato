package com.linya.admin.modules.shiro;

import com.linya.admin.dao.UmsAdminDao;
import com.linya.admin.dto.UmsAdminAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiroRealmService {
    @Autowired
    UmsAdminDao umsAdminDao;

    public List<UmsAdminAuth> getAdmin(String username) {
        return umsAdminDao.getList(username);
    }
}
