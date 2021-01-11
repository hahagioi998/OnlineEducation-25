package com.yzz.servicevod.vo;

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
public class AliVodVO {
	
	@Value("${ali_OSS.AccessKeyId}")
	private String accessKeyId;
	
	@Value("${ali_OSS.AccessKeySecret}")
	private String accessKeySecret;
	
	/**
	 * 同时定义2个静态变量
	 */

//	public static String AccessKeyId;
//	public static String AccessKeySecret;

}
