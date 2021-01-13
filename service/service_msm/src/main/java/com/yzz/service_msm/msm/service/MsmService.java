package com.yzz.service_msm.msm.service;

public interface MsmService {
	/**
	 * 向指定手机发送短信
	 * @param phoneNo
	 * @return
	 */
	boolean sendMsg(String phoneNo);
}
