package com.linya.admin.pms.brand;

import com.linya.admin.pms.brand.dao.BrandDao;
import com.linya.admin.po.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandDao dao;

    public List<UmsRole> getList() {
        return null;
    }

    public UmsRole find(String name) {
        return null;
    }
}
