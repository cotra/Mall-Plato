package com.linya.admin.modules.role;

import com.linya.admin.po.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    // 注册
    public List<Role> getList() {
        return roleDao.getList();
    }
}
