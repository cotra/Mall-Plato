package com.linya.admin.modules.shiro;

import com.linya.admin.dao.AuthDao;
import com.linya.admin.dao.UmsAdminDao;
import com.linya.admin.dto.UmsAdminAuth;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.po.UmsPermission;
import com.linya.admin.po.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShiroRealmService {
    @Autowired
    UmsAdminDao umsAdminDao;

    @Autowired
    AuthDao authDao;

    // 获得管理员
    public Cstp<UmsAdminAuth> getAdmin(String username) {

        List<UmsAdminAuth> list = umsAdminDao.getList(username);
        if(list.size() == 0 || list.size() != 1) {
            return Result.fail();
        }
        return Result.ok(list.get(0));
    }

    // 获得管理员角色列表
    public Cstp<Set<String>> getAdminRoles(Long id) {
        List<UmsRole> list = authDao.getRoleList(id);
        HashSet<String> hashSet = new HashSet<>();
        list.forEach(item -> hashSet.add(item.getName()));

        return Result.ok(hashSet);
    }

    // 获得管理员权限列表
    public Cstp<Set<String>> getAdminPerms(Long id) {
        List<UmsPermission> list = authDao.getPermissionList(id);
        HashSet<String> hashSet = new HashSet<>();
        list.forEach(item -> hashSet.add(item.getValue()));

        return Result.ok(hashSet);
    }
}
