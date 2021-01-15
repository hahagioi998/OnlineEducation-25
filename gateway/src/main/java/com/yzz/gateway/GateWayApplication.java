package com.yzz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName GateWayApplication
 * @Author yky
 * @Date 2021/1/15
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GateWayApplication.class, args);
	}
}
