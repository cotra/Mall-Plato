package com.linya.admin.ums.auth.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthDaoTest {

    @Autowired
    AuthDao dao;

    @Test
    public void updateLoginTime() {
        int i = dao.updateLoginTime(3L, new Date());
        System.out.println(i);
    }
}