package com.yzz.servicevod.controller;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.servicevod.service.VodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName VodController
 * @Author yky
 * @Date 2021/1/10
 * @Version 1.0
 */
@RestController
@Api(tags = "视频服务")
@Slf4j
@RequestMapping("/videoService")
@CrossOrigin
public class VodController {

	@Resource
	private VodService vodService;

	@ApiOperation("上传视频")
	@PostMapping("/upLoadVod")
	public ResultData upLoadVod(MultipartFile file){
		log.info("访问接口：上传视频");
		String videoId;
		try{
			videoId = vodService.upLoadVod(file);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：上传视频，结束");
		return ResultData.sucess().data("videoId", videoId);
	}
	
	
	@ApiOperation("删除视频")
	@DeleteMapping("/deleteVod")
	public ResultData deleteVod(@RequestParam @ApiParam("视频id") List<String> videoIdList){
		log.info("访问接口：删除视频");
		boolean flag;
		try{
			flag = vodService.deleteVod(videoIdList);
		}catch (Exception e){
			log.error(e.getLocalizedMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：删除视频，结束");
		return ResultData.sucess().data("flag", flag);
	}
}
