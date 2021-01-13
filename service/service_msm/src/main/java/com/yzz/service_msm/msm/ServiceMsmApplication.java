package com.yzz.service_msm.msm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName ServiceMsmApplication
 * @Author yky
 * @Date 2021/1/13
 * @Version 1.0
 */
@ComponentScan("com.yzz")
@SpringBootApplication
public class ServiceMsmApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceMsmApplication.class, args);
	}
}
