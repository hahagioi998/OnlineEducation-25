package com.yzz.service_edu.edu.controller;

import com.yzz.commonutils.vo.ResultData;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Author yky
 * @Date 2020/12/29
 * @Version 1.0
 */
@Slf4j
@Api(description = "登录controller")
@RestController
@RequestMapping("/loginservice")
@CrossOrigin
public class LoginController {
	
	
	/**
	 * 登录方法
	 * @return
	 */
	@PostMapping("/login")
	public ResultData login(){
		log.info("登录ing");
		return ResultData.sucess().data("token", "token");
	}
	
	/**
	 * 获取用户信息方法
	 * @return
	 */
	@GetMapping("/info")
	public ResultData getInfo(){
		log.info("获取用户信息ing");
		return ResultData.sucess().data("roles", "[admin]")
								  .data("name", "admin")
				                  .data("avatar", "outsider");
	}
}
