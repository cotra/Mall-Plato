package com.linya.admin.pms.brand;

import com.linya.admin.po.PmsBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceTest {

    @Autowired
    BrandService service;

    @Test
    public void getALlList() {
        List<PmsBrand> list = service.getALlList();
        list.forEach(System.out::println);
    }
}