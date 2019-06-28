package com.linya.admin;

import com.linya.admin.api.Api;
import com.linya.admin.api.ApiMaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Api<String> index() {
        return ApiMaker.ok("mall-prototype admin-back api service is running.");
    }
}
