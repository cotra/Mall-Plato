package com.linya.admin.ums.admin.dao;

import cn.hutool.core.date.DateUtil;
import com.linya.admin.po.UmsAdmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {
    @Autowired
    AdminDao dao;

    @Test
    public void getList() {
        UmsAdmin admin = new UmsAdmin();
        admin.setUsername("test");
        admin.setPassword("123");
        admin.setIcon("123");
        admin.setNickName("123445534");
        admin.setCreateTime(DateUtil.date());
        int add = dao.add(admin);
        System.out.println(admin.getId());
    }
}