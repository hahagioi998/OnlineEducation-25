package com.yzz.service_edu.edu.controller;


import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.dto.OneSubjectDTO;
import com.yzz.service_edu.edu.entity.Subject;
import com.yzz.service_edu.edu.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Slf4j
@Api(tags = "课程分类服务")
@RestController
@RequestMapping("/edu/subjectService")
@CrossOrigin
public class SubjectController {

	@Resource
	private SubjectService subjectService;

	@ApiOperation("添加课程分类")
	@PostMapping("/addSubject")
	public ResultData addSubject(@ApiParam("文件")MultipartFile file){
		log.info("访问接口：添加课程分类服务");
		try{
			subjectService.addSubject(file);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：添加课程分类服务，结束");
		return ResultData.sucess().data("data", "ok");
	}

	@ApiOperation("获取课程分类列表")
	@GetMapping("/listSubject")
	public ResultData listSubject(){
		log.info("访问接口：获取课程分类列表服务");
		List<OneSubjectDTO> list = new ArrayList<>();
		try{
			list =  subjectService.listSubject();
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：获取课程分类列表服务，结束");
		return ResultData.sucess().data("data", list);
	}

	@ApiOperation("获取一级课程")
	@GetMapping("/levelOneSubject")
	public ResultData levelOneSubject(){
		log.info("访问接口: 获取一级课程");
		List<Subject> list = new ArrayList<>();
		try{
			list = subjectService.getlevelOneSubject();
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口: 获取一级课程，结束");
		return ResultData.sucess().data("data", list);
	}

	@ApiOperation("根据一级课程获取二级课程")
	@GetMapping("/levelTwoByLevelOne")
	public ResultData levelTwoByLevelOne(@ApiParam("一级课程id")@RequestBody String id){
		log.info("访问接口：根据一级课程获取二级课程");
		List<Subject> list = new ArrayList<>();
		try{
			list = subjectService.getLevelTwoByLevelOne(id);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据一级课程获取二级课程，结束");
		return ResultData.sucess().data("data", list);
	}

}

