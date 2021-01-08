package com.yzz.service_edu.edu.mapper;

import com.yzz.service_edu.edu.dto.CourseDTO;
import com.yzz.service_edu.edu.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
