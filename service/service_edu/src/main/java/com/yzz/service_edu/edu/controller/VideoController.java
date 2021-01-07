package com.yzz.service_edu.edu.controller;


import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.entity.Video;
import com.yzz.service_edu.edu.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Slf4j
@Api(tags = "小节服务")
@RestController
@RequestMapping("/edu/videoService")
@CrossOrigin
public class VideoController {

	@Resource
	private VideoService videoService;

	@ApiOperation("新增小节")
	@PostMapping("/addVideo")
	public ResultData addVideo(@RequestBody Video video){
		log.info("访问接口：新增小节");
		int i ;
		try{
			i = videoService.addVideo(video);
		}catch (Exception e){
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：新增小节，结束");
		return ResultData.sucess().data("data", i);
	}

	@ApiOperation("删除小节")
	@DeleteMapping("/deleteVideo")
	public ResultData deleteVideo(@RequestParam String id){
		log.info("访问接口：删除小节");
		int i ;
		try{
			i = videoService.deleteVideo(id);
		}catch (Exception e){
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：删除小节，结束");
		return ResultData.sucess().data("data", i);
	}

	@ApiOperation("根据id查询小节")
	@GetMapping("/getVideteoById")
	public ResultData getVideoById(@RequestParam String id){
		log.info("访问接口：根据id查询小节");
		Video video ;
		try{
			video = videoService.getVideoById(id);
		}catch (Exception e){
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据id查询小节，结束");
		return ResultData.sucess().data("data", video);
	}

	@ApiOperation("更新小节")
	@PostMapping("/updateVideo")
	public ResultData updateVideo(@RequestBody Video video){
		log.info("访问接口：更新小节");
		int i ;
		try{
			i = videoService.updateVideo(video);
		}catch (Exception e){
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：更新小节，结束");
		return ResultData.sucess().data("data", i);
	}

}

