package com.yzz.service_edu.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName EduConfig
 * @Author yky
 * @Date 2020/12/25
 * @Version 1.0
 */
@Configuration
@MapperScan("com.yzz.service_edu.edu.mapper")
public class EduConfig {


}
