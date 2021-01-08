package com.yzz.service_edu.edu.controller;


import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.entity.Chapter;
import com.yzz.service_edu.edu.service.ChapterService;
import com.yzz.service_edu.edu.vo.ChapterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Slf4j
@Api(tags = "章节服务")
@RestController
@RequestMapping("/edu/chapterService")
@CrossOrigin
public class ChapterController {
	
	@Resource
	private ChapterService chapterService;
	
	
	@ApiOperation("获取课程大纲列表")
	@GetMapping("/getChapterList")
	public ResultData getChapterList(@ApiParam("课程id")@RequestParam String courseId){
		log.info("访问接口：获取课程大纲列表");
		List<ChapterVO> list = new ArrayList<>();
		try{
			list = chapterService.getChapterList(courseId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：获取课程大纲列表，结束");
		return ResultData.sucess().data("data", list);
	}

	@ApiOperation("新增章节")
	@PostMapping("/addChapter")
	public ResultData addChapter(@ApiParam("章节")@RequestBody Chapter chapter){
		log.info("访问接口：新增章节");
		int i = 0;
		try{
			i = chapterService.addChapter(chapter);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：新增章节，结束");
		return ResultData.sucess().data("data", i);
	}

	@ApiOperation("更新章节")
	@PostMapping("/updateChapter")
	public ResultData updateChapter(@ApiParam("章节")@RequestBody Chapter chapter){
		log.info("访问接口：更新章节");
		int i = 0;
		try{
			i = chapterService.updateChapter(chapter);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：更新章节，结束");
		return ResultData.sucess().data("data", i);
	}

	@ApiOperation("删除章节")
	@DeleteMapping("/deleteChapter")
	public ResultData deleteChapter(@ApiParam("章节id")@RequestParam String chapterId){
		log.info("访问接口：删除章节");
		int i = 0;
		try{
			i = chapterService.deleteChapter(chapterId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：删除章节，结束");
		return ResultData.sucess().data("data", i);
	}

	@ApiOperation("根据id获取章节")
	@GetMapping("/getChapter")
	public ResultData getChapter(@ApiParam("章节id")@RequestParam String chapterId){
		log.info("访问接口：根据id获取章节");
		Chapter chapter ;
		try{
			chapter = chapterService.getChapter(chapterId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据id获取章节，结束");
		return ResultData.sucess().data("data", chapter);
	}

}

