package com.yzz.service_edu.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.entity.Teacher;
import com.yzz.service_edu.edu.service.TeacherService;
import com.yzz.service_edu.edu.vo.TeacherQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yky
 * @since 2020-12-25
 */
@Slf4j
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/edu/teacherService")
@CrossOrigin
public class TeacherController {
	
	@Resource
	private TeacherService teacherService;
	
	@ApiOperation(value = "所有讲师列表")
	@GetMapping("/findAllTeach")
	public ResultData findAllTeach(){

		log.info("访问接口：所有讲师列表");
		List<Teacher> list = new ArrayList<>();
		try{
			list = teacherService.list(new QueryWrapper<>());
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：所有讲师列表，结束");
		return ResultData.sucess().data("data", list);
	}
	
	@ApiOperation(value = "逻辑删除讲师")
	@DeleteMapping("/deleteById/{id}")
	public ResultData deleteById(@ApiParam(value = "讲师ID") @PathVariable("id")String id){
		log.info("访问接口：逻辑删除讲师");
		boolean flag = false;
		try{
			flag = teacherService.removeById(id);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", flag);
		}
		log.info("访问接口：逻辑删除讲师，结束");
		return ResultData.sucess().data("data", flag);
	
	}
	
	@ApiOperation(value = "分页查询讲师")
	@GetMapping("/selectTPage/{currentPage}/{pageSize}")
	public ResultData selectTPage(@ApiParam(value = "当前页") @PathVariable("currentPage")Integer currentPage ,
	                              @ApiParam(value = "页大小") @PathVariable("pageSize")Integer pageSize){
		log.info("访问接口：分页查询讲师");
		HashMap<String, Object> hashMap = new HashMap<>();
		try{
			hashMap = teacherService.selectTPage(currentPage, pageSize);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.sucess().data("data", null);
		}
		log.info("访问接口：分页查询讲师，结束");
		return ResultData.sucess().data(hashMap);
		
	}
	
	@ApiOperation(value = "条件分页查询")
	@PostMapping("/selectTPageParam/{currentPage}/{pageSize}")
	public ResultData selectTPageParam(@ApiParam(value = "当前页") @PathVariable("currentPage")Integer currentPage ,
	                                   @ApiParam(value = "页大小") @PathVariable("pageSize")Integer pageSize,
	                                   @ApiParam(value = "teacher条件") @RequestBody(required = false) TeacherQueryVO teacherQueryVO){
		log.info("访问接口：条件分页查询");
		HashMap<String, Object> hashMap = new HashMap<>();
		try{
			hashMap = teacherService.selectTPageParam(currentPage, pageSize, teacherQueryVO);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：条件分页查询，结束");
		return ResultData.sucess().data(hashMap);
		
	}
	
	@ApiOperation(value = "增加讲师")
	@PostMapping("/insertT")
	public ResultData insertT(@ApiParam(value = "新增tearcher") @RequestBody(required = false) Teacher teacher){
		
		log.info("访问接口：增加讲师");
		HashMap<String, Object> hashMap = new HashMap<>();
		try{
			hashMap = hashMap = teacherService.insertT(teacher);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：增加讲师，结束");
		return ResultData.sucess().data(hashMap);
		
	}
	
	@ApiOperation(value = "根据ID查询讲师")
	@GetMapping("/queryTById")
	public ResultData queryTById(@ApiParam(value = "讲师ID") @RequestParam(required = true) String teacherId){
		
		log.info("访问接口：根据ID查询讲师");
		HashMap<String, Object> hashMap = new HashMap<>();
		try{
			hashMap = teacherService.queryTById(teacherId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据ID查询讲师，结束");
		return ResultData.sucess().data(hashMap);
		
	}
	
	@ApiOperation(value = "讲师信息更新")
	@PostMapping("/updateTearcher")
	public ResultData updateTearcher(@ApiParam(value = "修改后的tearcher信息") @RequestBody(required = true) Teacher teacher){
		
		log.info("访问接口：讲师信息更新");
		HashMap<String, Object> hashMap = new HashMap<>();
		try{
			hashMap = teacherService.updateTearcher(teacher);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：讲师信息更新，结束");
		return ResultData.sucess().data(hashMap);
		
	}


}

