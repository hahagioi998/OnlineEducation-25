package com.yzz.service_edu.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.dto.CourseDTO;
import com.yzz.service_edu.edu.entity.Course;
import com.yzz.service_edu.edu.service.CourseService;
import com.yzz.service_edu.edu.vo.CourseInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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
@Api(tags = "课程服务")
@RestController
@RequestMapping("/edu/courseService")
@CrossOrigin
public class CourseController {

	@Resource
	private CourseService courseService;

	@ApiOperation("添加课程信息")
	@PostMapping("/addCourseInfo")
	public ResultData addCourseInfo(@ApiParam("课程查询VO")@RequestBody CourseInfoVO courseInfoVO){
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
	
	@ApiOperation("根据课程id获取课程信息")
	@GetMapping("/getCourseInfoById")
	public ResultData getCourseInfoById(@ApiParam("课程id")@RequestParam String courseId){
		log.info("访问接口：根据课程id获取课程信息");
		CourseInfoVO courseInfoVO = new CourseInfoVO();
		try{
			courseInfoVO = courseService.getCourseInfoById(courseId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据课程id获取课程信息，结束");
		return ResultData.sucess().data("data", courseInfoVO);
	}
	
	@ApiOperation("根据课程id更新课程信息")
	@PostMapping("/updateCourseInfoById")
	public ResultData updateCourseInfoById(@ApiParam("课程查询VO")@RequestBody CourseInfoVO courseInfoVO){
		log.info("访问接口：根据课程id更新课程信息");
		int i = 0;
		try{
			i = courseService.updateCourseInfoById(courseInfoVO);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据课程id更新课程信息，结束");
		return ResultData.sucess().data("data", i);
	}
	
	@ApiOperation("根据课程id查询课程及其他信息")
	@GetMapping("/getCouseInfoById")
	public ResultData getCouseInfoById(@ApiParam("课程id")@RequestParam String courseId){
		log.info("访问接口：根据课程id查询课程及其他信息");
		CourseDTO courseDTO;
		try{
			courseDTO = courseService.getCouseInfoById(courseId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据课程id查询课程及其他信息，结束");
		return ResultData.sucess().data("data", courseDTO);
	}
	
	@ApiOperation("发布课程")
	@PostMapping("/publishCourse")
	public ResultData publishCourse(@ApiParam("课程id")@RequestParam String courseId){
		log.info("访问接口：发布课程");
		int i;
		try{
			i = courseService.publishCourse(courseId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：发布课程，结束");
		return ResultData.sucess().data("data", i);
	}
	
	@ApiOperation("条件分页查询课程")
	@PostMapping("/listCourseCondition")
	public ResultData listCourseCondition(@ApiParam("当前页") @RequestParam int current,
	                                      @ApiParam("页容量") @RequestParam int size,
	                                      @ApiParam("课程条件") @RequestBody Course course){
		log.info("访问接口：条件分页查询课程");
		HashMap<String, Object> hashMap;
		try{
			hashMap = courseService.listCourseCondition(current, size, course);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：条件分页查询课程，结束");
		return ResultData.sucess().data("data", hashMap);
	}

	//加事务注解
	@Transactional
	@ApiOperation("删除课程")
	@DeleteMapping("/deleteCourse")
	public ResultData deleteCourse(@ApiParam("课程Id") @RequestParam String courseId){
		log.info("访问接口：删除课程");
		int i ;
		try{
			i = courseService.deleteCourseById(courseId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：删除课程，结束");
		return ResultData.sucess().data("data", i);
	}
	

}

