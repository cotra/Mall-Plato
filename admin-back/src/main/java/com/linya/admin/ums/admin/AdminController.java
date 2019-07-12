package com.linya.admin.ums.admin;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.ums.UmsApiUrl;
import com.linya.admin.ums.admin.dto.AddReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = UmsApiUrl.ADMIN)
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping("add")
    public Api<Long> add(@RequestBody @Validated AddReq req) {
        Cstp<Long> cstp = service.add(req);
        if(cstp.isOk()) {
            return Sender.ok("添加管理员成功", cstp.getData());
        } else {
            return Sender.fail("添加管理员失败", null);
        }
    }
}
