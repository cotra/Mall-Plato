package com.linya.admin.ums.admin;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Result;
import com.linya.admin.modules.cstp.Cstp;
import com.linya.admin.modules.cstp.Sender;
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
        Cstp<String> cstp = Sender.ok();
        if(cstp.isOk()) {
            return Result.ok("添加管理员成功");
        } else {
            return Result.ok("添加管理员失败");
        }
    }
}
