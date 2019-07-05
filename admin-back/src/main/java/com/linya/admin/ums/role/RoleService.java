package com.linya.admin.ums.role;

import com.linya.admin.ums.role.dao.RoleDao;
import com.linya.admin.po.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao dao;

    public List<UmsRole> getList() {
        return dao.getList();
    }

    public UmsRole find(String name) {
        return dao.find(name);
    }
}
