package com.linya.admin.dao;

import com.linya.admin.dto.UmsAdminAuth;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminDaoTest {

    @Autowired
    UmsAdminDao dao;

    @Test
    public void getList() {
        List<UmsAdminAuth> list = dao.getList("admin");
        System.out.println(list.get(0).toString());
    }
}