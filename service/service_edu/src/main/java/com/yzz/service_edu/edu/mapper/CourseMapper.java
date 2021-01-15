package com.yzz.service_edu.edu.mapper;

import com.yzz.service_edu.edu.dto.CourseDTO;
import com.yzz.service_edu.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzz.service_edu.edu.vo.front.CourseWebVO;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
public interface CourseMapper extends BaseMapper<Course> {

	CourseDTO getPublishCourseInfo(String courseId);
	
	/**
	 * 根据课程id查询课程信息，课程描述
	 * @param courseId
	 * @return
	 */
	CourseWebVO getCourseDetails(String courseId);
}
