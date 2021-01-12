package com.yzz.serviceacl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceAclApplication
 * @Author yky
 * @Date 2021/1/12
 * @Version 1.0
 */
@ComponentScan("com.yzz")
@SpringBootApplication
public class ServiceAclApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAclApplication.class, args);
	}
}
