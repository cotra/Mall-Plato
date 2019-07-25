package com.linya.admin.pms.brand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceTest {

    @Autowired
    BrandService service;

    @Test
    public void getALlList() {
//        Cstp<List<PmsBrand>> list = service.getPageList();
//        list.getData().forEach(System.out::println);
    }
}