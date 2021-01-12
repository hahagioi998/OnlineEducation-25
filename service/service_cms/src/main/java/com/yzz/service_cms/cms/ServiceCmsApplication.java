package com.yzz.service_cms.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName com.yzz.service_cms.cms.ServiceCmsApplication
 * @Author yky
 * @Date 2021/1/12
 * @Version 1.0
 */
@ComponentScan("com.yzz")
@SpringBootApplication
public class ServiceCmsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceCmsApplication.class, args);
	}
	
}
