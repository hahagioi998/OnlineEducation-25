package com.yzz.servicevod.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VodService {
	/**
	 * 上传视频
	 * @param file
	 * @return
	 */
	String upLoadVod(MultipartFile file) throws IOException;

	/**
	 * 删除视频
	 * @param videoIdList
	 * @return
	 */
	boolean deleteVod(List<String> videoIdList) throws Exception;
}
