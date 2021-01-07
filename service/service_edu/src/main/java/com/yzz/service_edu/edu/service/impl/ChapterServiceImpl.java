package com.yzz.service_edu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzz.service_edu.edu.entity.Chapter;
import com.yzz.service_edu.edu.entity.Video;
import com.yzz.service_edu.edu.mapper.ChapterMapper;
import com.yzz.service_edu.edu.mapper.VideoMapper;
import com.yzz.service_edu.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzz.service_edu.edu.service.VideoService;
import com.yzz.service_edu.edu.vo.ChapterVO;
import com.yzz.service_edu.edu.vo.VideoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-01-05
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
	
	
	@Resource
	private ChapterMapper chapterMapper;
	
	@Resource
	private VideoService videoService;
	
	@Override
	public List<ChapterVO> getChapterList(String courseId) {
		List<Chapter> chapterList = new ArrayList<>();
		List<Video> videoList = new ArrayList<>();
		List<ChapterVO> result = new ArrayList<>();
		QueryWrapper<Chapter> qwChapter = new QueryWrapper<>();
		//获取课程章节和课程小节
		qwChapter.eq("course_id", courseId);
		chapterList = chapterMapper.selectList(qwChapter);
		videoList = videoService.getVideoList(courseId);
		//匹配章节和小节
		for (int i = 0; i < chapterList.size(); i++) {
			ChapterVO chapterVO = new ChapterVO();
			BeanUtils.copyProperties(chapterList.get(i), chapterVO);
			List<VideoVO> videoVOList = new ArrayList<>();
			for (int j = 0; j < videoList.size(); j++) {
				if(chapterList.get(i).getId().equals(videoList.get(j).getChapterId())){
					VideoVO videoVO = new VideoVO();
					BeanUtils.copyProperties(videoList.get(j), videoVO);
					videoVOList.add(videoVO);
				}
			}
			chapterVO.setVideoVOList(videoVOList);
			result.add(chapterVO);
		}
		return result;
	}
}
