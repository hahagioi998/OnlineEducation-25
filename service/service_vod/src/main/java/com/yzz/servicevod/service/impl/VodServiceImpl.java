package com.yzz.servicevod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.servicevod.service.VodService;
import com.yzz.servicevod.vo.AliVod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @ClassName VodServiceImpl
 * @Author yky
 * @Date 2021/1/10
 * @Version 1.0
 */
@Slf4j
@Service
public class VodServiceImpl implements VodService {

	@Resource
	private AliVod aliVod;
	@Override
	public String upLoadVod(MultipartFile file) throws IOException {
		String name = file.getOriginalFilename();
		HashMap<String, Object> hashMap = uploadVideo(aliVod.getAccessKeyId(),
				                                      aliVod.getAccessKeySecret(), name, name, file.getInputStream());
		if(hashMap.getOrDefault("VideoId", null) == null){
			log.error("上传视频失败，失败原因: {}", hashMap.get("ErrorCode"));
			throw new YzzException(201, "上传视频失败");
		}
		return (String) hashMap.get("VideoId");
	}

	/**
	 * 本地文件上传接口
	 *
	 * @param accessKeyId
	 * @param accessKeySecret
	 * @param title
	 * @param fileName
	 */
	private HashMap<String, Object> uploadVideo(String accessKeyId, String accessKeySecret, String title, String fileName, InputStream inputStream) {
		HashMap<String, Object> hashMap = new HashMap<>();
		UploadStreamRequest request = new UploadStreamRequest(accessKeyId, accessKeySecret, title, fileName, inputStream);
		UploadVideoImpl uploader = new UploadVideoImpl();
		UploadStreamResponse response = uploader.uploadStream(request);

		System.out.print("RequestId="+response.getRequestId()+ "\n");  //请求视频点播服务的请求ID
		if (response.isSuccess()) {
			hashMap.put("VideoId", response.getVideoId());
			return hashMap;
		} else {
			/* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
			hashMap.put("VideoId", response.getVideoId());
			hashMap.put("ErrorCode", response.getCode());
			hashMap.put("ErrorMessage", response.getMessage());
			return hashMap;
		}
	}
}
