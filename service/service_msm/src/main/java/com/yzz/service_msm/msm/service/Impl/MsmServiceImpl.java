package com.yzz.service_msm.msm.service.Impl;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.yzz.commonutils.jwt.RandomUtils;
import com.yzz.commonutils.vo.AliOSS;
import com.yzz.service_msm.msm.service.MsmService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MsmServiceImpl
 * @Author yky
 * @Date 2021/1/13
 * @Version 1.0
 */
@Slf4j
@Service
public class MsmServiceImpl implements MsmService {
	
	@Resource
	private AliOSS aliOSS;
	
	@Override
	public boolean sendMsg(String phoneNo) {
		Map<String, Object> param = new HashMap<>();
		//随机生成4位验证码
		String code = RandomUtils.getFourBitRandom();
		
		param.put("code", code);
		
		if(StringUtils.isEmpty(phoneNo)){
			log.error("手机号码为空");
			return false;
		}
		
		DefaultProfile defaultProfile = DefaultProfile.getProfile("default", aliOSS.getAccessKeyId(), aliOSS.getAccessKeySecret());
		IAcsClient iAcsClient = new DefaultAcsClient(defaultProfile);
		CommonRequest commonRequest = new CommonRequest();
		commonRequest.setMethod(MethodType.POST);
		commonRequest.setDomain("dysmsapi.aliyuncs.com");
		commonRequest.setVersion("2017-05-25");
		commonRequest.setAction("SendSms");
		commonRequest.putQueryParameter("PhoneNumbers", phoneNo);
		//todo 把签名的名称完善下
		commonRequest.putQueryParameter("SignName", phoneNo);
		commonRequest.putQueryParameter("TemplateCode", "SMS_209550067");
		commonRequest.putQueryParameter("TemplateParam", JSONObject.wrap(param).toString());
		
		return false;
	}
}
