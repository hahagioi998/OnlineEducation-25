package com.yzz.serviceoss.vo;

import com.sun.corba.se.spi.activation.EndPointInfo;
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
public class AliOSS implements InitializingBean {
	
	@Value("${ali_OSS.endpoint}")
	private String endpoint;
	
	@Value("${ali_OSS.BucketName}")
	private String bucketName;
	
	@Value("${ali_OSS.AccessKeyId}")
	private String accessKeyId;
	
	@Value("${ali_OSS.AccessKeySecret}")
	private String accessKeySecret;
	
	/**
	 * 同时定义4个静态变量
	 */
	public static String EndPoint;
	public static String BucketName;
	public static String AccessKeyId;
	public static String AccessKeySecret;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		EndPoint = this.endpoint;
		BucketName = this.bucketName;
		AccessKeySecret = this.accessKeySecret;
		AccessKeyId = this.accessKeyId;
	}
}
