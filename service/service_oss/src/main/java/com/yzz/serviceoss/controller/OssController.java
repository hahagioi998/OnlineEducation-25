package com.yzz.serviceoss.controller;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.serviceoss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @ClassName OssController
 * @Author yky
 * @Date 2020/12/31
 * @Version 1.0
 */
@Slf4j
@Api(tags = "Oss管理")
@RestController
@RequestMapping("/fileOssService")
//@CrossOrigin
public class OssController {
	
	@Resource
	private OssService service;
	
	@ApiOperation("上传头像方法")
	@PostMapping("/upImg")
	public ResultData upLoadOss(MultipartFile file){
		
		log.info("访问上传头像接口...");
		String returnUrl = service.upLoadAvatar(file);
		return ResultData.success().data("data", returnUrl);
	}
}
