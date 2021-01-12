package com.yzz.servicevod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName VodApplication
 * @Author yky
 * @Date 2021/1/9
 * @Version 1.0
 */
@ComponentScan("com.yzz")
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceVodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceVodApplication.class, args);
	}
}
