package com.linya.admin.pms.brand;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.pms.PmsApiUrl;
import com.linya.admin.po.PmsBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PmsApiUrl.BRAND)
public class BrandController {

    @Autowired
    BrandService service;

    @GetMapping("all")
    public Api<List<PmsBrand>> all() {
        Cstp<List<PmsBrand>> cstp = service.getALlList();
        return Sender.ok(cstp.getData());
    }
}
