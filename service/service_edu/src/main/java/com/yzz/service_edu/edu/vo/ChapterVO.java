package com.yzz.service_edu.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ChapterVO
 * @Author yky
 * @Date 2021/1/7
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterVO {
	
	private String id;
	
	private String title;
	
	private List<VideoVO> videoVOList = new ArrayList<>();
	
}
