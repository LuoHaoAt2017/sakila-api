package com.imooc.sakila;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
@MapperScan("com.imooc.sakila.mapper")
public class SakilaApplication {

	public static void main(String[] args) {
		System.out.println("Spring 版本号：" + SpringVersion.getVersion());
		System.out.println("Spring Boot 版本号：" + SpringBootVersion.getVersion());
		SpringApplication.run(SakilaApplication.class, args);
	}

}
