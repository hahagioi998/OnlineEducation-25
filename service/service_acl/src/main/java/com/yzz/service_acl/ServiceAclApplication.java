package com.yzz.service_acl;

import com.yzz.yzzsecurity.config.TokenWebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @ClassName ServiceAclApplication
 * @Author yky
 * @Date 2021/1/12
 * @Version 1.0
 */
@ComponentScan(basePackages = {"com.yzz", "com.yzz.yzzsecurity"})
@SpringBootApplication(scanBasePackages = "com.yzz")
@EnableDiscoveryClient
public class ServiceAclApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceAclApplication.class, args);
	}
}
