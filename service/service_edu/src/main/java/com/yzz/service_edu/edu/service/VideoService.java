package com.yzz.service_edu.edu.service;

import com.yzz.service_edu.edu.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
public interface VideoService extends IService<Video> {
	
	/**
	 * 获取课程的全部小节
	 * @param courseId
	 * @return
	 */
	List<Video> getVideoList(String courseId);

	/**
	 * 根据章节id删除小节
	 * @param chapterId
	 */
	void deleteByChapterId(String chapterId);

	/**
	 * 新增小节
	 * @param video
	 * @return
	 */
	int addVideo(Video video);

	/**
	 * 删除小节
	 * @param id
	 * @return
	 */
	int deleteVideo(String id);

	/**
	 * 根据id查询小节
	 * @param id
	 * @return
	 */
	Video getVideoById(String id);

	/**
	 * 更新小节
	 * @param video
	 * @return
	 */
	int updateVideo(Video video);
	
	/**
	 * 根据courseId删除小节
	 * @param courseId
	 * @return
	 */
	int deleteVideoByCourseId(String courseId);

	/**
	 * 根据courseId查询视频id
	 * @param courseId
	 * @return
	 */
	List<String> getBatchIdByCourseId(String courseId);
}
