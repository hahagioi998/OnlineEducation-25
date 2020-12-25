package com.yzz.commonutils.vo;

import com.yzz.commonutils.constant.StatusCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResultData
 * @Author yky
 * @Date 2020/12/25
 * @Version 1.0
 */
@Data
public class ResultData {
	
	@ApiModelProperty(value = "是否成功")
	private Boolean success;
	
	@ApiModelProperty(value = "返回码")
	private StatusCode code;
	
	@ApiModelProperty(value = "返回消息")
	private String message;
	
	@ApiModelProperty(value = "返回数据")
	private Map<String, Object> data = new HashMap<String, Object>();
	
	//把构造方法私有
	private ResultData() {}
	
	//成功静态方法
	public static ResultData sucess() {
		ResultData r = new ResultData();
		r.setSuccess(true);
		r.setCode(StatusCode.Success);
		r.setMessage("成功");
		return r;
	}
	
	//失败静态方法
	public static ResultData failed() {
		ResultData r = new ResultData();
		r.setSuccess(false);
		r.setCode(StatusCode.Failed);
		r.setMessage("失败");
		return r;
	}
	
	public ResultData success(Boolean success){
		this.setSuccess(success);
		return this;
	}
	
	public ResultData message(String message){
		this.setMessage(message);
		return this;
	}
	
	public ResultData code(StatusCode code){
		this.setCode(code);
		return this;
	}
	
	public ResultData data(String key, Object value){
		this.data.put(key, value);
		return this;
	}
	
	public ResultData data(Map<String, Object> map){
		this.setData(map);
		return this;
	}
}
