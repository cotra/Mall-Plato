package com.linya.admin.modules.shiro;

import com.linya.admin.dao.UmsAdminDao;
import com.linya.admin.dto.UmsAdminAuth;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiroRealmService {
    @Autowired
    UmsAdminDao umsAdminDao;

    public Cstp<UmsAdminAuth> getAdmin(String username) {
        List<UmsAdminAuth> list = umsAdminDao.getList(username);
        if(list.size() == 0 || list.size() != 1) {
            return Sender.fail();
        }
        return Sender.ok(list.get(0));
    }
}
