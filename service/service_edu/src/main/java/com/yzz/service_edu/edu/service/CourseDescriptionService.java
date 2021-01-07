package com.yzz.service_edu.edu.service;

import com.yzz.service_edu.edu.entity.CourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
public interface CourseDescriptionService extends IService<CourseDescription> {

	/**
	 * 添加课程描述
	 * @param courseDescription
	 * @return
	 */
	int insertCourseDescription(CourseDescription courseDescription);
	
	/**
	 * 根据课程id获取课程描述
	 * @param courseId
	 * @return
	 */
	CourseDescription getCourseDesInfoById(String courseId);
	
	/**
	 * 根据课程id更新课程描述
	 * @param courseId
	 * @param description
	 * @return
	 */
	int updateCourseDesById(String courseId, String description);
}
