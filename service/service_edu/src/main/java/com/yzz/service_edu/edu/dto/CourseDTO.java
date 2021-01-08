package com.yzz.service_edu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CourseDTO
 * @Author yky
 * @Date 2021/1/8
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
	
	private String id;
	
	private String title;
	
	private String cover;
	
	private Integer lessonNum;
	
	private String subjectLevelOne;
	
	private String subjectLevelTwo;
	
	private String teacherName;
	
	private String price;
}
