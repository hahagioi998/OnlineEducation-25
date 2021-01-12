package com.yzz.servicevod.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VodService {
	/**
	 * 上传视频
	 * @param file
	 * @return
	 */
	String upLoadVod(MultipartFile file) throws IOException;
	
	/**
	 * 删除视频
	 * @param videoId
	 * @return
	 */
	boolean deleteVod(String videoId) throws Exception;
}