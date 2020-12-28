package com.yzz.servicebase.handler;

import com.yzz.commonutils.constant.StatusCode;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.commonutils.vo.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ExceptionHandler
 * @Author yky
 * @Date 2020/12/28
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionHandler {


	/**
	 * 所有异常处理
	 * @param e
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultData error(Exception e){
		e.printStackTrace();
		return ResultData.failed().message("执行了全局异常处理。");
	}

	/**
	 * 数组越界异常
	 * @param e
	 * @return
	 */
	public ResultData error(IndexOutOfBoundsException e){
		e.printStackTrace();
		return ResultData.failed().message("数组下标越界。");
	}

	/**
	 * 自定义异常
	 * @param e
	 * @return
	 */
	public ResultData error(YzzException e){
		e.printStackTrace();
		return ResultData.failed().code(StatusCode.Error).message(e.getMessage());
	}
}
