package com.yzz.service_ucenter.ucenter.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName RegisterVO
 * @Author yky
 * @Date 2021/1/13
 * @Version 1.0
 */
@Data
public class RegisterVO {
	
	@NotNull(message = "姓名不能为空")
	@ApiModelProperty(value = "姓名")
	private String nickname;
	
	@NotNull(message = "密码不能为空")
	@ApiModelProperty(value = "密码")
	private String password;
	
	@NotNull(message = "验证码不能为空")
	@ApiModelProperty(value = "验证码")
	private String verfiyCode;
	
	@NotNull(message = "手机号不能为空")
	@ApiModelProperty(value = "手机号")
	private String mobile;
}
