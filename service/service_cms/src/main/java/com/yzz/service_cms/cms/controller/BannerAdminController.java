package com.yzz.service_cms.cms.controller;


import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_cms.cms.entity.CrmBanner;
import com.yzz.service_cms.cms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 首页banner表 前端控制器
 * </p>
 *
 * @author yky
 * @since 2021-01-12
 */
@Api(tags = "bannerAdmin服务")
@Slf4j
@RestController
@RequestMapping("/cms/Admin")
@CrossOrigin
public class BannerAdminController {
	
	@Resource
	private CrmBannerService crmBannerService;
	
	@ApiOperation("分页查询banner")
	@GetMapping("/queryByPages")
	public ResultData queryByPages(@RequestParam @ApiParam("当前页") int current,
	                               @RequestParam @ApiParam("页容量") int pageSize){
		log.info("访问接口：分页查询banner");
		HashMap<String, Object> hashMap = new HashMap<>();
		try{
			hashMap = crmBannerService.queryByPages(current, pageSize);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：分页查询banner，结束");
		return ResultData.sucess().data("map",hashMap);
	}
	
	@ApiOperation("添加banner")
	@PostMapping("/addBanner")
	public ResultData addBanner(@RequestBody @ApiParam("banner对象") CrmBanner crmBanner){
		log.info("访问接口：添加banner");
		int i;
		try{
			i = crmBannerService.addBanner(crmBanner);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：添加banner，结束");
		return ResultData.sucess().data("data", i);
	}
	
	@ApiOperation("删除banner")
	@DeleteMapping("/deleteBanner")
	public ResultData addBanner(@RequestParam @ApiParam("bannerId") String bannerId){
		log.info("访问接口：删除banner");
		int i;
		try{
			i = crmBannerService.deleteBanner(bannerId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：删除banner，结束");
		return ResultData.sucess().data("data", i);
	}
	
	@ApiOperation("更新banner")
	@PostMapping("/updateBanner")
	public ResultData updateBanner(@RequestBody @ApiParam("banner对象") CrmBanner crmBanner){
		log.info("访问接口：更新banner");
		int i;
		try{
			i = crmBannerService.updateBanner(crmBanner);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：更新banner，结束");
		return ResultData.sucess().data("data", i);
	}
	
	@ApiOperation("根据id查询banner")
	@PostMapping("/queryBannerById")
	public ResultData queryBannerById(@RequestParam @ApiParam("bannerId") String bannerId){
		log.info("访问接口：根据id查询banner");
		CrmBanner crmBanner;
		try{
			crmBanner = crmBannerService.queryBannerById(bannerId);
		}catch (Exception e){
			log.error(e.getMessage());
			log.error(e.fillInStackTrace().toString());
			return ResultData.failed().data("data", null);
		}
		log.info("访问接口：根据id查询banner，结束");
		return ResultData.sucess().data("data", crmBanner);
	}

}

