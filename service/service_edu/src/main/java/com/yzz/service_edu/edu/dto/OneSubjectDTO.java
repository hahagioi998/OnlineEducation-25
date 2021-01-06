package com.yzz.service_edu.edu.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OneSubject
 * @Author yky
 * @Date 2021/1/5
 * @Version 1.0
 */
@Data
public class OneSubjectDTO {

	private String id;

	private String title;

	private List<TwoSubjectDTO> children = new ArrayList<>();
}
