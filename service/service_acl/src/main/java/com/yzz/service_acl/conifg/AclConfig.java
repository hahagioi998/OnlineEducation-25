package com.yzz.service_acl.conifg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AclConfig
 * @Author yky
 * @Date 2021/1/18
 * @Version 1.0
 */
@Configuration
@MapperScan("com.yzz.service_acl.mapper")
public class AclConfig {
}
