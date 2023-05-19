package com.yff.demo.gateway.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GatewayConfigApplication {

	public static void main(String[] args)  {
		SpringApplication.run(GatewayConfigApplication.class, args);
	}
}
