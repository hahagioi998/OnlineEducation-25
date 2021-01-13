package com.yzz.service_ucenter.ucenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceUCenterApplication
 * @Author yky
 * @Date 2021/1/13
 * @Version 1.0
 */
@ComponentScan("com.yzz")
@SpringBootApplication
public class ServiceUCenterApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceUCenterApplication.class, args);
	}
}
