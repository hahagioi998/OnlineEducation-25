package com.yzz.serviceoss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceOssApplication
 * @Author yky
 * @Date 2020/12/31
 * @Version 1.0
 */
@ComponentScan("com.yzz")
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ServiceOssApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceOssApplication.class, args);
	}
}
