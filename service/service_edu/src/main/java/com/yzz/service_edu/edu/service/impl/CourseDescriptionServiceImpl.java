package com.yzz.service_edu.edu.service.impl;

import com.yzz.commonutils.exception.YzzException;
import com.yzz.service_edu.edu.entity.CourseDescription;
import com.yzz.service_edu.edu.mapper.CourseDescriptionMapper;
import com.yzz.service_edu.edu.service.CourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService {

	@Resource
	private CourseDescriptionMapper courseDescriptionMapper;
	@Override
	public int insertCourseDescription(CourseDescription courseDescription) {
		int i = 0;
		i = courseDescriptionMapper.insert(courseDescription);
		if(i == 0){
			throw  new YzzException(201, "添加课程描述信息失败");
		}
		return i;
	}
}
