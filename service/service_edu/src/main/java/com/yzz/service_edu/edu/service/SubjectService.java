package com.yzz.service_edu.edu.service;

import com.yzz.service_edu.edu.dto.OneSubjectDTO;
import com.yzz.service_edu.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
public interface SubjectService extends IService<Subject> {

	/**
	 * 添加课程分类
	 * @param file
	 */
	void addSubject(MultipartFile file) throws IOException;

	/**
	 * 获取课程列表
	 */
	List<OneSubjectDTO> listSubject();

	/**
	 * 获取一级课程
	 * @return
	 */
	List<Subject> getlevelOneSubject();

	/**
	 * 根据一级课程id获取二级课程
	 * @param id
	 * @return
	 */
	List<Subject> getLevelTwoByLevelOne(String id);
}
