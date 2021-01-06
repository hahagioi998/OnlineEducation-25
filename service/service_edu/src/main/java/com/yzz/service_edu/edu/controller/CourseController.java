package com.yzz.service_edu.edu.controller;


import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.service.CourseService;
import com.yzz.service_edu.edu.vo.CourseInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Slf4j
@Api(tags = "课程服务")
@RestController
@RequestMapping("/edu/courseService")
@CrossOrigin
public class CourseController {

	@Resource
	private CourseService courseService;

	@ApiOperation("添加课程信息")
	@PostMapping("/addCourseInfo")
	public ResultData addCourseInfo(@RequestBody CourseInfoVO courseInfoVO){
		log.info("访问接口：添加课程信息");
		String courseId = null;
		try{
			courseId = courseService.insertCourseInfo(courseInfoVO);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：添加课程信息，结束");
		return ResultData.sucess().data("data", courseId);
	}
	

}

