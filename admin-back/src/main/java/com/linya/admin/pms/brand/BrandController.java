package com.linya.admin.pms.brand;

import com.linya.admin.dto.ResPageList;
import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.pms.PmsApiUrl;
import com.linya.admin.pms.brand.dto.BrandListReq;
import com.linya.admin.po.PmsBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PmsApiUrl.BRAND)
public class BrandController {

    @Autowired
    BrandService service;

    @PostMapping("list")
    public Api<ResPageList<PmsBrand>> list(@RequestBody @Validated BrandListReq req) {
        Cstp<ResPageList<PmsBrand>> cstp = service.getPageList(req.getSize(), req.getPage());
        return Sender.ok(cstp.getData());
    }
}
