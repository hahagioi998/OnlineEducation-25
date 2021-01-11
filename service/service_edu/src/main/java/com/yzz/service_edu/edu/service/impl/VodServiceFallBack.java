package com.yzz.service_edu.edu.service.impl;

import com.yzz.commonutils.vo.ResultData;
import com.yzz.service_edu.edu.service.VodService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName VodServiceFallBack
 * @Author yky
 * @Date 2021/1/11
 * @Version 1.0
 */
@Slf4j
@Component
public class VodServiceFallBack implements FallbackFactory<VodService> {


	@Override
	public VodService create(Throwable throwable) {
		log.error("调用vod服务删除视频出错");
		return new VodService() {
			@Override
			public ResultData deleteVod(List<String> videoIdList) {
				return ResultData.failed().data("data", 123);
			}
		};
	}
}
