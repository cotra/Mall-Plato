package com.linya.admin.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class CommandLine implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("服务启动成功");
    }
}
