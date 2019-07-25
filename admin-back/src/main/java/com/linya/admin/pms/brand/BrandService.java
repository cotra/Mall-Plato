package com.linya.admin.pms.brand;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linya.admin.dto.PageList;
import com.linya.admin.dto.PlusPage;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.pms.brand.dao.BrandDao;
import com.linya.admin.po.PmsBrand;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends ServiceImpl<BrandDao, PmsBrand> implements IService<PmsBrand> {

    public Cstp<PageList<PmsBrand>> getPageList() {
        IPage<PmsBrand> page = page(new PlusPage<>(5, 1));

        PageList<PmsBrand> list = new PageList<>(page.getRecords(), page.getTotal(), page.getSize(), page.getCurrent());

        return Result.ok(list);
    }
}
