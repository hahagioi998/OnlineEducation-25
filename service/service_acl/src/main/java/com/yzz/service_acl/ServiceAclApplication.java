package com.yzz.service_acl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceAclApplication
 * @Author yky
 * @Date 2021/1/12
 * @Version 1.0
 */
@ComponentScan("com.yzz")
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAclApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAclApplication.class, args);
	}
}
