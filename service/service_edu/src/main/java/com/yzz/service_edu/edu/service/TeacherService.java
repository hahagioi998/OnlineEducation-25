package com.yzz.service_edu.edu.service;

import com.github.pagehelper.PageInfo;
import com.yzz.service_edu.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzz.service_edu.edu.vo.TeacherQuery;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author yky
 * @since 2020-12-25
 */
public interface TeacherService extends IService<Teacher> {

	HashMap<String, Object> selectTPage (int currentPage, int pageSize);
	
	HashMap<String, Object> selectTPageParam(int currentPage, int pageSize, TeacherQuery teacherQuery);

	HashMap<String, Object> insertT(Teacher teacher);
}
