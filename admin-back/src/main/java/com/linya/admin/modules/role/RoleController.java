package com.linya.admin.modules.role;

import com.linya.admin.api.Api;
import com.linya.admin.api.ApiMaker;
import com.linya.admin.po.UmsRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    RoleService service;

    /**
     * 注册登录账户名不能为纯数字,不能有@等特殊字符,只能是字母或字母+数字
     */
    @GetMapping("list")
    public Api<List<UmsRole>> list() {
        List<UmsRole> list = service.getList();
        return ApiMaker.ok(list);
    }

    @GetMapping("find")
    public Api<UmsRole> find() {
        UmsRole role = service.find();
        return ApiMaker.ok(role);
    }
}
