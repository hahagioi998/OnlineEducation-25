package com.yzz.service_ucenter.ucenter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName UcenterConfig
 * @Author yky
 * @Date 2021/1/13
 * @Version 1.0
 */
@Configuration
@MapperScan("com.yzz.service_ucenter.ucenter.mapper")
public class UcenterConfig {
}
