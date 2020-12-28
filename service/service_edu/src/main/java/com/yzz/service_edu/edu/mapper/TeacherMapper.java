package com.yzz.service_edu.edu.mapper;

import com.yzz.service_edu.edu.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author yky
 * @since 2020-12-25
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
	
	Integer updateTearcher(Teacher teacher);
	
	Integer insertT(Teacher teacher);
}
