package com.linya.admin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.baomidou.mybatisplus.samples.quickstart.mapper", "com.linya.admin.dao", "com.linya.admin.ums.*.dao", "com.linya.admin.pms.*.dao"})
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLimit(1000);
        return paginationInterceptor;
    }
}
