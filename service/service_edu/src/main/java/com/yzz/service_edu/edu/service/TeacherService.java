package com.yzz.service_edu.edu.service;

import com.yzz.service_edu.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzz.service_edu.edu.vo.TeacherQueryVO;

import java.util.HashMap;

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
	
	HashMap<String, Object> selectTPageParam(int currentPage, int pageSize, TeacherQueryVO teacherQueryVO);

	HashMap<String, Object> insertT(Teacher teacher);
	
	HashMap<String, Object> queryTById(String teacherId);
	
	HashMap<String, Object> updateTearcher(Teacher teacher);
}
