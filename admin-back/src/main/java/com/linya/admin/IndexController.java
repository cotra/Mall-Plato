package com.linya.admin;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Api<String> index() {
        return Sender.ok("mall-prototype admin-back api service is running.");
    }
}
