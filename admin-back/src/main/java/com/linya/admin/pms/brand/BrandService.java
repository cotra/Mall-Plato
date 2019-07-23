package com.linya.admin.pms.brand;

import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.pms.brand.dao.BrandDao;
import com.linya.admin.po.PmsBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandDao dao;

    public Cstp<List<PmsBrand>> getALlList() {
        List<PmsBrand> list = dao.selectList(null);
        if(list != null) {
            return Result.ok(list);
        }
        return Result.ok(new ArrayList<>());
    }
}
