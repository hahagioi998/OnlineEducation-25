package com.yzz.service_ucenter.ucenter.service;

import com.yzz.service_ucenter.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yzz.service_ucenter.ucenter.vo.RegisterVO;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author yky
 * @since 2021-01-13
 */
public interface MemberService extends IService<Member> {
	
	/**
	 * 用户登录
	 * @param member
	 * @return
	 */
	String loginIn(Member member);
	
	/**
	 * 用户注册
	 * @param registerVO
	 * @return
	 */
	boolean register(RegisterVO registerVO);
	
	/**
	 * 根据token获取用户信息
	 * @param request
	 * @return
	 */
	Member getInfoByToken(HttpServletRequest request);
}
