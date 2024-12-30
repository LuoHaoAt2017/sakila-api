package com.imooc.sakila.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedOrigins("http://localhost:5173")
                .allowedOrigins("*")
                .allowedMethods(new String[] {"GET", "POST", "PUT", "DELETE"})
                .allowedHeaders("*");
    }
}
