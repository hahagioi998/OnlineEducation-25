package com.yzz.service_msm.msm.controller;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_msm.msm.service.MsmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName MsmController
 * @Author yky
 * @Date 2021/1/13
 * @Version 1.0
 */
@Api(tags = "短信服务")
@RestController
@Slf4j
@RequestMapping("/msm/MsmService")
@CrossOrigin
public class MsmController {
	
	@Resource
	private MsmService msmService;
	
	@ApiOperation("发送短信至手机")
	@PostMapping("/sendMsg")
	public ResultData sendMsg(@RequestParam @ApiParam("手机号")String phoneNo){
		log.info("访问接口：发送短信至手机");
		boolean flag;
		try{
			flag = msmService.sendMsg(phoneNo);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", "短信发送异常");
		}
		log.info("访问接口：发送短信至手机，结束");
		
		return flag ? ResultData.sucess().data("data", "短信发送成功")
				: ResultData.failed().data("data", "短信发送失败");
	}
}
