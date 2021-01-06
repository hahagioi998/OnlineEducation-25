package com.yzz.service_edu.edu.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName ExcelSubjectData
 * @Author yky
 * @Date 2021/1/5
 * @Version 1.0
 */
@Data
public class ExcelSubjectDataVO {

	@ExcelProperty(value = "一级分类", index = 0)
	private String oneSubjectName;

	@ExcelProperty(value = "二级分类", index = 1)
	private String twoSubjectName;
}
