package com.yff.demo.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NacosConfigApplication {

	public static void main(String[] args)  {
		SpringApplication.run(NacosConfigApplication.class, args);


//		ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigApplication.class, args);
//		//第一种读取nacos配置的方式
//		String userName = applicationContext.getEnvironment().getProperty("user.name");
//		String userAge = applicationContext.getEnvironment().getProperty("user.age");
//		String xx = applicationContext.getEnvironment().getProperty("xx.xx");
//		System.err.println("user name :"+userName);
//		System.err.println("age: "+userAge);
//		System.err.println("xx: "+xx);

	}
}
