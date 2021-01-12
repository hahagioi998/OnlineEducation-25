package com.yzz.service_edu.edu.controller.front;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.entity.Course;
import com.yzz.service_edu.edu.entity.Teacher;
import com.yzz.service_edu.edu.service.CourseService;
import com.yzz.service_edu.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IndexController
 * @Author yky
 * @Date 2021/1/12
 * @Version 1.0
 */
@Slf4j
@Api(tags = "前台首页服务")
@RestController
@RequestMapping("/edu/IndexController")
@CrossOrigin
public class IndexController {
	
	@Resource
	private TeacherService teacherService;
	
	@Resource
	private CourseService courseService;
	
	@Cacheable(value = "hotCourse", key = "'queryHotCourse'")
	@ApiOperation("获取热门课程")
	@GetMapping("/queryHotCourse")
	public ResultData queryHotCourse(){
		log.info("访问接口：获取热门课程");
		List<Course> list = new ArrayList<>();
		try{
			list = courseService.queryHotCourse();
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：获取热门课程，结束");
		
		return ResultData.sucess().data("list", list);
	}
	
	@Cacheable(value = "hotTeacher", key = "'queryHotTeacher'")
	@ApiOperation("获取老师排名")
	@GetMapping("/queryHotTeacher")
	public ResultData queryHotTeacher(){
		log.info("访问接口：获取老师排名");
		List<Teacher> list = new ArrayList<>();
		try{
			list = teacherService.queryHotCourse();
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：获取老师排名，结束");
		
		return ResultData.sucess().data("list", list);
	}
}
