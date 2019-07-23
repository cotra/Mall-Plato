package com.linya.admin.pms.brand.dao;

import com.linya.admin.po.PmsBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandDaoTest {

    @Autowired
    BrandDao dao;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<PmsBrand> userList = dao.selectList(null);
        userList.forEach(System.out::println);
    }
}