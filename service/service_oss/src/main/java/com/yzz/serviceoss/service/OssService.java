package com.yzz.serviceoss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName OssService
 * @Author yky
 * @Date 2020/12/31
 * @Version 1.0
 */
public interface OssService {
	
	/**
	 * 上传头像到oss
	 * @param file
	 * @return
	 */
	String upLoadAvatar(MultipartFile file);
}
