package com.linya.admin.dao;

import com.linya.admin.po.UmsPermission;
import com.linya.admin.po.UmsRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthDaoTest {

    @Autowired
    AuthDao dao;

    @Test
    public void getRoleList() {
        List<UmsRole> list = dao.getRoleList(3L);
        System.out.println(list.size());
    }

    @Test
    public void getPermissionList() {
        List<UmsPermission> list = dao.getPermissionList(3L);
        System.out.println(list.size());
    }
}