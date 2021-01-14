package com.yzz.service_edu.edu.controller.front;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.entity.Course;
import com.yzz.service_edu.edu.service.CourseService;
import com.yzz.service_edu.edu.vo.front.CourseQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CourseFrontController
 * @Author yky
 * @Date 2021/1/14
 * @Version 1.0
 */
@Api(tags = "前台讲师服务")
@Slf4j
@RestController
@RequestMapping("/edu/courseFrontService")
@CrossOrigin
public class CourseFrontController {
	
	@Resource
	private CourseService courseService;
	
	@ApiOperation("前台条件分页查询课程")
	@GetMapping("/queryCByPageOnCondition")
	public ResultData queryCByPageOnCondition(@RequestParam @ApiParam("当前页") int current,
	                                          @RequestParam @ApiParam("页容量") int pageSize,
	                                          @RequestBody(required = false) @ApiParam("查询课程条件") CourseQueryVO courseQueryVO){
		log.info("访问接口：前台条件分页查询课程");
		HashMap<String, Object> result = new HashMap<>();
		try{
			result = courseService.queryCByPageOnCondition(current, pageSize, courseQueryVO);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：前台条件分页查询课程，结束");
		return ResultData.sucess().data("data", result);
	}
}
