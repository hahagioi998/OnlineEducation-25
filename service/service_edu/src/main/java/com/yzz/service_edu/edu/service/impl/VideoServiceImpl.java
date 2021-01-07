package com.yzz.service_edu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzz.service_edu.edu.entity.Video;
import com.yzz.service_edu.edu.mapper.VideoMapper;
import com.yzz.service_edu.edu.service.VideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
	
	@Resource
	private VideoMapper videoMapper;
	
	@Override
	public List<Video> getVideoList(String courseId) {
		
		QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
		
		return videoMapper.selectList(queryWrapper);
	}

	@Override
	public void deleteByChapterId(String chapterId) {
		QueryWrapper<Video> qw = new QueryWrapper<>();
		qw.eq("chapter_id", chapterId);
		videoMapper.delete(qw);
	}

	@Override
	public int addVideo(Video video) {
		return videoMapper.insert(video);
	}

	@Override
	public int deleteVideo(String id) {
		return videoMapper.deleteById(id);
	}

	@Override
	public Video getVideoById(String id) {
		return videoMapper.selectById(id);
	}

	@Override
	public int updateVideo(Video video) {
		return videoMapper.updateById(video);
	}
}
