package com.linya.admin;

import com.linya.admin.web.api.Api;
import com.linya.admin.web.api.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Api<String> index() {
        return Result.ok("mall-prototype admin-back api service is running.");
    }
}
