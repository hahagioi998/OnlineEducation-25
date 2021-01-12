package com.yzz.service_cms.cms.controller;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_cms.cms.entity.CrmBanner;
import com.yzz.service_cms.cms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BannerClientController
 * @Author yky
 * @Date 2021/1/12
 * @Version 1.0
 */
@Api(tags = "bannerClient服务")
@Slf4j
@RestController
@RequestMapping("/cms/Client")
@CrossOrigin
public class BannerClientController {
	
	@Resource
	private CrmBannerService crmBannerService;
	
	@ApiOperation("查询所有banner")
	@GetMapping("/getAllBanner")
	public ResultData getAllBanner(){
		log.info("访问接口：查询所有banner");
		List<CrmBanner> bannerList = new ArrayList<>();
		try{
			bannerList = crmBannerService.getAllBanner();
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data",null);
		}
		log.info("访问接口：查询所有banner，结束");
		
		return ResultData.sucess().data("list",bannerList);
	}

}
