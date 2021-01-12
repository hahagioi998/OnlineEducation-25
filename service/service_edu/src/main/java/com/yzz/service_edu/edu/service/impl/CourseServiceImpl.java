package com.yzz.service_edu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.PageList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.service_edu.edu.dto.CourseDTO;
import com.yzz.service_edu.edu.entity.Course;
import com.yzz.service_edu.edu.entity.CourseDescription;
import com.yzz.service_edu.edu.mapper.CourseDescriptionMapper;
import com.yzz.service_edu.edu.mapper.CourseMapper;
import com.yzz.service_edu.edu.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzz.service_edu.edu.vo.CourseInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

	@Resource
	private CourseMapper courseMapper;

	@Resource
	private CourseDescriptionService courseDescriptionService;
	
	@Resource
	private ChapterService chapterService;
	
	@Resource
	private VideoService videoService;

	@Resource
	private VodService vodService;

	@Override
	public String insertCourseInfo(CourseInfoVO courseInfoVO) {

		//添加课程
		Course course = new Course();
		BeanUtils.copyProperties(courseInfoVO, course);
		int i = 0;
		i = courseMapper.insert(course);
		if(i == 0){
			throw new YzzException(201, "添加课程信息失败");
		}
		//添加课程描述
		CourseDescription courseDescription = new CourseDescription();
		courseDescription.setDescription(courseInfoVO.getDescription());
		courseDescription.setId(course.getId());
		int j = 0;
		j = courseDescriptionService.insertCourseDescription(courseDescription);
		if( i != j){
			throw new YzzException(201, "添加课程信息失败");
		}
		return course.getId();
	}
	
	@Override
	public CourseInfoVO getCourseInfoById(String courseId) {
		QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
		CourseInfoVO courseInfoVO = new CourseInfoVO();
		Course course = new Course();
		CourseDescription courseDescription = new CourseDescription();
		
		queryWrapper.eq("id", courseId);
		course = courseMapper.selectOne(queryWrapper);
		courseDescription = courseDescriptionService.getCourseDesInfoById(courseId);
		
		BeanUtils.copyProperties(course, courseInfoVO);
		courseInfoVO.setDescription(courseDescription.getDescription());
		
		return courseInfoVO;
	}
	
	@Override
	public int updateCourseInfoById(CourseInfoVO courseInfoVO) {
		
		String courseId = courseInfoVO.getId();
		Course course = new Course();
		
		BeanUtils.copyProperties(courseInfoVO, course);
		int i = courseMapper.updateById(course);
		int j = courseDescriptionService.updateCourseDesById(courseId, courseInfoVO.getDescription());
		if(i <= 0 || j<= 0){
			throw new YzzException(201, "更新课程信息 或 更新课程描述失败");
		}
		return i;
	}
	
	@Override
	public CourseDTO getCouseInfoById(String courseId) {
		return courseMapper.getPublishCourseInfo(courseId);
	}
	
	@Override
	public int publishCourse(String courseId) {
		QueryWrapper<Course> qw = new QueryWrapper<>();
		qw.eq("id", courseId);
		Course course = new Course();
		course.setStatus("Normal");
		return courseMapper.update(course, qw);
	}
	
	@Override
	public HashMap<String, Object> listCourseCondition(int current, int size, Course course) {
		PageHelper.startPage(current, size);
		QueryWrapper<Course> qw = new QueryWrapper<>();
		HashMap<String, Object> hashMap = new HashMap<>();
		String status = course.getStatus();
		String title = course.getTitle();
		
		if(!StringUtils.isEmpty(title)){
			qw.like("title", title);
		}
		if(!StringUtils.isEmpty(status)){
			qw.eq("status", status);
		}
		qw.orderByDesc("gmt_create");
		
		List<Course> list = courseMapper.selectList(qw);
		PageInfo<Course> pageList = new PageInfo<>(list);
		hashMap.put("total", pageList.getTotal());
		hashMap.put("list", pageList.getList());
		
		return hashMap;
	}
	
	@Override
	public int deleteCourseById(String courseId) {
		//根据courseId删除视频
		List<String> videoIdList = videoService.getBatchIdByCourseId(courseId);
		//如果有视频再去调用接口删除
		if(videoIdList.size() > 0)
			if(!(Boolean) vodService.deleteVod(videoIdList).getData().get("flag"))
				throw new YzzException(201, "删除课程过程中，删除课程中的视频异常");
		//根据courseId删除小节
		int deleteVideo = videoService.deleteVideoByCourseId(courseId);
		//根据courseId删除章节
		int deleteChapter = chapterService.deleteChapterByCourseId(courseId);
		//根据courseId删除课程描述
		int deleteCourseDes = courseDescriptionService.deleteCourseDes(courseId);
		//根据courseId删除课程
		int deleteCourse = courseMapper.deleteById(courseId);
		if( deleteVideo <= 0 || deleteChapter <= 0 || deleteCourseDes <= 0 || deleteCourse <= 0){
			throw new YzzException(201, "删除课程失败");
		}else{
			return deleteCourse;
		}
	}
}
