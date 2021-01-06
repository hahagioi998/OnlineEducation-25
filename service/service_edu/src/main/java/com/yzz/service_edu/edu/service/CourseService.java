package com.yzz.service_edu.edu.service;

import com.yzz.service_edu.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzz.service_edu.edu.vo.CourseInfoVO;

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
}
