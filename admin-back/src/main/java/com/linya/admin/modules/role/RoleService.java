package com.linya.admin.modules.role;

import com.linya.admin.modules.role.dao.RoleDao;
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

    public UmsRole find() {
        return dao.find("商品管理员");
    }
}
