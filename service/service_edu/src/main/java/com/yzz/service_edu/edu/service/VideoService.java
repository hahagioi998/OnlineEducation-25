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
}