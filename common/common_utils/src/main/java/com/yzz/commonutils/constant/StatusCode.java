package com.yzz.commonutils.constant;

import lombok.Data;


public enum StatusCode {
	
	Success(200), Failed(500), Error(201);
	
	private int code;
	
	StatusCode(Integer code){
		this.code = code;
	}
	
	public int getCode(){
		return code;
	}
}
