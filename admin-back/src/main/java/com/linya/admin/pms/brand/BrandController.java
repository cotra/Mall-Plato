package com.linya.admin.pms.brand;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.pms.PmsApiUrl;
import com.linya.admin.po.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = PmsApiUrl.TEST)
public class BrandController {
    @Autowired
    BrandService service;

    @GetMapping("list")
    public Api<List<UmsRole>> list() {

        List<UmsRole> list = service.getList();
        return Sender.ok(list);
    }

    @GetMapping("add")
    public Api<String> add() {
        return Sender.ok();
    }


    @GetMapping("find")
    public Api<UmsRole> find() {
        UmsRole role = service.find("商品管理员");
        return Sender.ok(role);
    }
}
