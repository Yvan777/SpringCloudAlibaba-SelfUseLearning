package com.yf.demo.microa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication //springboot启动注解
@MapperScan(basePackages = "com.yf.demo.microa.business.mapper")
@EnableFeignClients(basePackages = "com.yf.demo.microa.feign") //启用OpenFeign
public class MicroaApplication {

	public static void main(String[] args)  {
		SpringApplication.run(MicroaApplication.class, args);
	}
}
