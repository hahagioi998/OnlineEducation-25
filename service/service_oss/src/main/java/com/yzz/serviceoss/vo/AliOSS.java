package com.yzz.serviceoss.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
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
public class AliOSS {
	
	@Value("${ali_OSS.endpoint}")
	private String endpoint;
	
	@Value("${ali_OSS.bucketName}")
	private String bucketName;
	
	@Value("${ali_OSS.AccessKeyId}")
	private String accessKeyId;
	
	@Value("${ali_OSS.AccessKeySecret}")
	private String accessKeySecret;
	
}
