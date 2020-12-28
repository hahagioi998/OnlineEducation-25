package com.yzz.service_edu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzz.service_edu.edu.entity.Teacher;
import com.yzz.service_edu.edu.mapper.TeacherMapper;
import com.yzz.service_edu.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzz.service_edu.edu.vo.TeacherQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author yky
 * @since 2020-12-25
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
	
	@Resource
	private TeacherMapper teacherMapper;
	
	@Override
	public HashMap<String, Object> selectTPage(int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<Teacher> list = teacherMapper.selectList(new QueryWrapper<>());
		PageInfo<Teacher> pageInfo = new PageInfo<>(list);
		HashMap<String, Object> map = new HashMap<>();
		map.put("total", pageInfo.getTotal());
		map.put("list", pageInfo.getList());
		return map;
	}
	
	@Override
	public HashMap<String, Object> selectTPageParam(int currentPage, int pageSize, TeacherQuery teacherQuery) {
		
		PageHelper.startPage(currentPage, pageSize);
		QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
		String name = teacherQuery.getName();
		Integer level = teacherQuery.getLevel();
		String begin = teacherQuery.getBegin();
		String end = teacherQuery.getEnd();
		
		if(!StringUtils.isEmpty(name)){
			queryWrapper.like("name", name);
		}
		if(null != level){
			queryWrapper.eq("level", level);
		}
		if(!StringUtils.isEmpty(begin)){
			queryWrapper.ge("gmt_create", begin);
		}
		if(!StringUtils.isEmpty(end)){
			queryWrapper.le("gmt_create", end);
		}
		
		List<Teacher> list = teacherMapper.selectList(queryWrapper);
		PageInfo<Teacher> pageInfo = new PageInfo<>(list);
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("total", pageInfo.getTotal());
		hashMap.put("list", pageInfo.getList());
		
		return hashMap;
	}
	
	@Override
	public HashMap<String, Object> insertT(Teacher teacher) {
		HashMap<String, Object> hashMap = new HashMap<>();
		int i = teacherMapper.insertT(teacher);
		hashMap.put("result", i);
		return hashMap;
	}
	
	@Override
	public HashMap<String, Object> queryTById(String teacherId) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		Teacher t = teacherMapper.selectById(teacherId);
		hashMap.put("result", t);
		return hashMap;
	}
	
	@Override
	public HashMap<String, Object> updateTearcher(Teacher teacher) {
		
		HashMap<String, Object> hashMap = new HashMap<>();
		Integer i = teacherMapper.updateTearcher(teacher);
		hashMap.put("result", i);
		return hashMap;
	}
}
