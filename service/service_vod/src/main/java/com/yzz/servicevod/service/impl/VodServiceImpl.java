package com.yzz.servicevod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.commonutils.vo.AliOSS;
import com.yzz.servicevod.service.VodService;
import com.yzz.servicevod.config.InitObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

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
	private AliOSS aliOSS;
	
	@Override
	public String upLoadVod(MultipartFile file) throws IOException {
		String name = file.getOriginalFilename();
		HashMap<String, Object> hashMap = uploadVideo(aliOSS.getAccessKeyId(),
				aliOSS.getAccessKeySecret(), name, name, file.getInputStream());
		if(hashMap.getOrDefault("VideoId", null) == null){
			log.error("上传视频失败，失败原因: {}", hashMap.get("ErrorCode"));
			throw new YzzException(201, "上传视频失败");
		}
		return (String) hashMap.get("VideoId");
	}

	@Override
	public boolean deleteVod(List<String> videoIdList) throws Exception {
		DefaultAcsClient client = InitObject.initVodClient(aliOSS.getAccessKeyId(), aliOSS.getAccessKeySecret());
		DeleteVideoResponse response = new DeleteVideoResponse();
		response = deleteVideo(client, videoIdList);
		log.info("删除视频requestId: {}", response.getRequestId());
		return true;
	}
	
	@Override
	public String getAuthById(String vidoId) throws ClientException {
		
		DefaultAcsClient defaultAcsClient = InitObject.initVodClient(aliOSS.getAccessKeyId(), aliOSS.getAccessKeySecret());
		GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
		request.setVideoId(vidoId);
		GetVideoPlayAuthResponse response = defaultAcsClient.getAcsResponse(request);
		return response.getPlayAuth();
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
	
	/**
	 * 删除视频
	 * @param client 发送请求客户端
	 * @param videoIdList 视频idList
	 * @return DeleteVideoResponse 删除视频响应数据
	 * @throws Exception
	 */
	public DeleteVideoResponse deleteVideo(DefaultAcsClient client, List<String> videoIdList) throws Exception {
		DeleteVideoRequest request = new DeleteVideoRequest();
		String videoIdStr = StringUtils.join(videoIdList, ",");
		//支持传入多个视频ID，多个用逗号分隔
		request.setVideoIds(videoIdStr);
		return client.getAcsResponse(request);
	}
}
