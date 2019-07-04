package com.linya.admin.modules.dao;

import com.linya.admin.po.UmsRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminDaoTest {

    @Autowired
    UmsAdminDao dao;

    @Test
    public void getList() {
        List<UmsRole> list = dao.getList();
        System.out.println(list.size());
    }
}