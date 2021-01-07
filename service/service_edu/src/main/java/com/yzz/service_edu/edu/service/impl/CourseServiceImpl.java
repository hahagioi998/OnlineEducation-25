package com.yzz.service_edu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.service_edu.edu.entity.Course;
import com.yzz.service_edu.edu.entity.CourseDescription;
import com.yzz.service_edu.edu.mapper.CourseDescriptionMapper;
import com.yzz.service_edu.edu.mapper.CourseMapper;
import com.yzz.service_edu.edu.service.CourseDescriptionService;
import com.yzz.service_edu.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzz.service_edu.edu.vo.CourseInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
