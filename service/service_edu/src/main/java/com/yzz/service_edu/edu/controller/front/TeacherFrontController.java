package com.yzz.service_edu.edu.controller.front;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.entity.Course;
import com.yzz.service_edu.edu.entity.Teacher;
import com.yzz.service_edu.edu.service.CourseService;
import com.yzz.service_edu.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName TeacherFrontController
 * @Author yky
 * @Date 2021/1/14
 * @Version 1.0
 */
@Api(tags = "前台讲师服务")
@Slf4j
@RestController
@RequestMapping("/edu/teacherFrontService")
//@CrossOrigin
public class TeacherFrontController {
	
	@Resource
	private TeacherService teacherService;
	
	@Resource
	private CourseService courseService;
	
	@ApiOperation("查询讲师信息和课程")
	@GetMapping("/queryTInfoCInfo")
	public ResultData queryTInfoCInfo(@RequestParam @ApiParam("讲师id")String teacherId){
		log.info("访问接口：查询讲师信息和课程");
		HashMap<String, Object> result = new HashMap<>();
		List<Course> courseList;
		try{
			courseList = courseService.queryCInfoByTId(teacherId);
			HashMap<String, Object> hashMap = teacherService.queryTById(teacherId);
			result.putAll(hashMap);
			result.put("courseList", courseList);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：查询讲师信息和课程，结束");
		return ResultData.success().data("data", result);
		
	}
}
