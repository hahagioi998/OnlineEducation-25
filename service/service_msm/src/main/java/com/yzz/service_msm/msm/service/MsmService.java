package com.yzz.service_msm.msm.service;

import com.aliyuncs.exceptions.ClientException;

public interface MsmService {
	/**
	 * 向指定手机发送短信
	 * @param phoneNo
	 * @return
	 */
	boolean sendMsg(String phoneNo) throws ClientException;
}
