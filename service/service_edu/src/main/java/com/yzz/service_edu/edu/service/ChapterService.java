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

	/**
	 * 新增章节
	 * @param chapter
	 * @return
	 */
	int addChapter(Chapter chapter);

	/**
	 * 更新章节
	 * @param chapter
	 * @return
	 */
	int updateChapter(Chapter chapter);

	/**
	 * 删除章节
	 * @param chapterId
	 * @return
	 */
	int deleteChapter(String chapterId);

	/**
	 * 根据id获取章节
	 * @param chapterId
	 * @return
	 */
	Chapter getChapter(String chapterId);
	
	/**
	 * 根据courseId删除章节
	 * @param courseId
	 * @return
	 */
	int deleteChapterByCourseId(String courseId);
}
