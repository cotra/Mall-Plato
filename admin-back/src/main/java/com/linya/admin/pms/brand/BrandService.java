package com.linya.admin.pms.brand;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linya.admin.dto.ResPageList;
import com.linya.admin.dto.PlusPage;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.pms.brand.dao.BrandDao;
import com.linya.admin.po.PmsBrand;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends ServiceImpl<BrandDao, PmsBrand> implements IService<PmsBrand> {

    public Cstp<ResPageList<PmsBrand>> getPageList(long size, long page) {
        IPage<PmsBrand> list = page(new PlusPage<>(size, page));

        ResPageList<PmsBrand> resPageList = new ResPageList<>(list.getRecords(), list.getTotal(), list.getSize(), list.getCurrent());

        return Result.ok(resPageList);
    }
}
