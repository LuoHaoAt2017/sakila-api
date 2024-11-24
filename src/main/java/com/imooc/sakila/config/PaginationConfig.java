package com.imooc.sakila.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaginationConfig {

    /**
     * 分页插件
     */
    // fix: MyBatis Plus 分页查询返回的 数据总数total为0 的解决方案.
    @Bean
    public PaginationInterceptor mybatisPlusInterceptor() {
        return new PaginationInterceptor();
    }
}
