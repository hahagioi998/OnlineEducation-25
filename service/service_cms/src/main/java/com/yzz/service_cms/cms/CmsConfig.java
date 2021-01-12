package com.yzz.service_cms.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName CmsConfig
 * @Author yky
 * @Date 2021/1/12
 * @Version 1.0
 */
@Configuration
@MapperScan("com.yzz.service_cms.cms.mapper")
public class CmsConfig {
}
