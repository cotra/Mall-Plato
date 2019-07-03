package com.linya.admin.app.role;

import com.linya.admin.api.Api;
import com.linya.admin.api.ApiMaker;
import com.linya.admin.po.UmsRole;
import com.linya.admin.route.RouteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RouteConfig.API_ROLE)
public class RoleController {
    @Autowired
    RoleService service;

    @GetMapping("list")
    public Api<List<UmsRole>> list() {
        List<UmsRole> list = service.getList();
        return ApiMaker.ok(list);
    }

    @GetMapping("find")
    public Api<UmsRole> find() {
        UmsRole role = service.find("商品管理员");
        return ApiMaker.ok(role);
    }
}
