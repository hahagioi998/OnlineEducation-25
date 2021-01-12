package com.yzz.service_edu.edu.service;

import com.yzz.service_edu.edu.dto.CourseDTO;
import com.yzz.service_edu.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzz.service_edu.edu.vo.CourseInfoVO;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
public interface CourseService extends IService<Course> {

	/**
	 * 新增课程信息
	 * @param courseInfoVO
	 * @return
	 */
	String insertCourseInfo(CourseInfoVO courseInfoVO);
	
	/**
	 * 根据课程id获取课程信息
	 * @param courseId
	 * @return
	 */
	CourseInfoVO getCourseInfoById(String courseId);
	
	/**
	 * 根据课程id更新课程信息
	 * @param courseInfoVO
	 * @return
	 */
	int updateCourseInfoById(CourseInfoVO courseInfoVO);
	
	/**
	 * 根据课程id查询课程及其他信息
	 * @param courseId
	 * @return
	 */
	CourseDTO getCouseInfoById(String courseId);
	
	/**
	 * 发布课程
	 * @param courseId
	 * @return
	 */
	int publishCourse(String courseId);
	
	/**
	 * 条件分页查询课程
	 * @param current
	 * @param size
	 * @param course
	 * @return
	 */
	HashMap<String, Object> listCourseCondition(int current, int size, Course course);
	
	/**
	 * 删除课程根据courseid
	 * @param courseId
	 * @return
	 */
	int deleteCourseById(String courseId);
	
	/**
	 * 获取热门课程
	 * @return
	 */
	List<Course> queryHotCourse();
}
