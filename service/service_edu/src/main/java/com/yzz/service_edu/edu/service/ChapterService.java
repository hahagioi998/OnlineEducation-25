package com.yzz.service_edu.edu.service;

import com.yzz.service_edu.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzz.service_edu.edu.vo.ChapterVO;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
public interface ChapterService extends IService<Chapter> {
	
	/**
	 * 获取章节大纲列表
	 * @param courseId
	 * @return
	 */
	List<ChapterVO> getChapterList(String courseId);
}
