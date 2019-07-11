package com.linya.admin.ums.admin;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Result;
import com.linya.admin.ums.UmsApiUrl;
import com.linya.admin.ums.admin.dto.AddReq;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = UmsApiUrl.ADMIN)
public class AdminController {

    @RequiresGuest
    @PostMapping("add")
    public Api<String> add(@RequestBody @Validated AddReq req) {
        System.out.println(req.toString());
        Cstp<String> cstp = Result.ok();
        if(cstp.isOk()) {
            return Sender.ok("添加管理员成功");
        } else {
            return Sender.ok("添加管理员失败");
        }
    }
}
