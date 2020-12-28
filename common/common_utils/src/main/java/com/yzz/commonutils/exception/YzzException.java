package com.yzz.commonutils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName YzzException
 * @Author yky
 * @Date 2020/12/28
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class YzzException extends RuntimeException {


	/**
	 * 异常状态码
	 */
	private Integer code;

	/**
	 * 异常信息
	 */
	private String msg;
}
