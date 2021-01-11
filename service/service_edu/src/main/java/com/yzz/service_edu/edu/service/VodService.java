package com.yzz.service_edu.edu.service;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.service.impl.VodServiceFallBack;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName VodService
 * @Author yky
 * @Date 2021/1/11
 * @Version 1.0
 */
@FeignClient(value = "service-vod", fallbackFactory = VodServiceFallBack.class)
@Component
public interface VodService {
	
	@DeleteMapping("/videoService/deleteVod")
	public ResultData deleteVod(@RequestParam @ApiParam("视频id") List<String> videoIdList);
}
