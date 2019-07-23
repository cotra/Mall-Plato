package com.linya.admin;

import com.linya.admin.modules.exception.DefaultExceptionHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.baomidou.mybatisplus.samples.quickstart.mapper", "com.linya.admin.dao", "com.linya.admin.ums.*.dao", "com.linya.admin.pms.*.dao"})
public class AdminApplication implements CommandLineRunner {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("服务启动成功");
    }
}
