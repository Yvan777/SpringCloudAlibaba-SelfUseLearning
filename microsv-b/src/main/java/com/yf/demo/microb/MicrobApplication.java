package com.yf.demo.microb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.yf.demo.microb.feign")
public class MicrobApplication {

	public static void main(String[] args)  {
		SpringApplication.run(MicrobApplication.class, args);
	}
}
