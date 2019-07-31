package com.linya.admin.bootstrap;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Letter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Api<String> index() {
        return Letter.ok("Mall-Plato admin-back api service is running.");
    }
}
