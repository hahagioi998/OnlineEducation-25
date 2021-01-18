package com.yzz.yzzsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName YzzSecurityApplication
 * @Author yky
 * @Date 2021/1/18
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.yzz")
public class YzzSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(YzzSecurityApplication.class, args);
	}
}
