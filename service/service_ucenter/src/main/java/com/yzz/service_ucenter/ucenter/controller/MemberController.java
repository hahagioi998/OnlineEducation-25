package com.yzz.service_ucenter.ucenter.controller;


import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_ucenter.ucenter.entity.Member;
import com.yzz.service_ucenter.ucenter.service.MemberService;
import com.yzz.service_ucenter.ucenter.vo.RegisterVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-01-13
 */
@Api(tags = "用户登录服务")
@RestController
@RequestMapping("/ucenter/member")
@Slf4j
@CrossOrigin
public class MemberController {
	
	@Resource
	private MemberService memberService;
	
	@ApiOperation("用户注册")
	@PostMapping("/register")
	public ResultData register(@RequestBody @ApiParam("memberVO") @Valid RegisterVO registerVO, BindingResult bindingResult){
		log.info("访问接口：用户注册");
		//参数校验
		if(bindingResult.hasErrors())
			return ResultData.failed().data("data", bindingResult.toString());
		
		boolean flag;
		try{
			flag = memberService.register(registerVO);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：用户注册，结束");

		return ResultData.sucess().data("data", null);
	}
	
	@ApiOperation("用户登录")
	@PostMapping("/loginIn")
	public ResultData loginIn(@RequestBody @ApiParam("用户json")Member member){
		log.info("访问接口：用户登录");
		String token;
		try{
			token = memberService.loginIn(member);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：用户登录，结束");
		
		return ResultData.sucess().data("token", token);
	}
	
	@ApiOperation("根据token获取用户信息")
	@GetMapping("/getInfoByToken")
	public ResultData getInfoByToken(@ApiParam("requestHeader")HttpServletRequest request){
		log.info("访问接口：根据token获取用户信息");
		Member member;
		try{
			member = memberService.getInfoByToken(request);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据token获取用户信息，结束");
		
		return ResultData.sucess().data("token", member);
	}

}

