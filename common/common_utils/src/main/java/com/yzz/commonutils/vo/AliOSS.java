package com.yzz.commonutils.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName AliOSS
 * @Author yky
 * @Date 2020/12/31
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@PropertySource("classpath:/AliOSS.properties")
public class AliOSS {
	
	@Value("${AliOSS.endpoint}")
	private String endpoint;
	
	@Value("${AliOSS.bucketName}")
	private String bucketName;
	
	@Value("${AliOSS.AccessKeyId}")
	private String accessKeyId;
	
	@Value("${AliOSS.AccessKeySecret}")
	private String accessKeySecret;
	
}
