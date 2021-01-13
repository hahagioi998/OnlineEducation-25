package com.yzz.service_ucenter.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.commonutils.jwt.JwtUtils;
import com.yzz.commonutils.jwt.MD5;
import com.yzz.service_ucenter.ucenter.entity.Member;
import com.yzz.service_ucenter.ucenter.mapper.MemberMapper;
import com.yzz.service_ucenter.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzz.service_ucenter.ucenter.vo.RegisterVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-01-13
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
	
	@Resource
	private MemberMapper memberMapper;
	
	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public String loginIn(Member member) {
		String mobile = member.getMobile();
		String password = member.getPassword();
		
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password))
			throw new YzzException(201,"当前用户手机号或者密码为空");
		
		
		QueryWrapper<Member> qw = new QueryWrapper<>();
		qw.eq("mobile", mobile);
		Member queryMember = memberMapper.selectOne(qw);
		if(queryMember == null)
			throw new YzzException(201, "查不到当前手机号对应的用户");
		
		//把输入的密码加密后进行比对
		if(!MD5.encrypt(password).equals(queryMember.getPassword()))
			throw new YzzException(201, "密码错误，登录失败");
		
		if(queryMember.getIsDisabled())
			throw new YzzException(201, "当前用户已经被禁用");
		
		//生成token
		
		return JwtUtils.getJwtToken(queryMember.getId(), queryMember.getNickname());
	}
	
	@Override
	public boolean register(RegisterVO registerVO) {
		
		String verfiyCode = registerVO.getVerfiyCode();
		String mobileNo = registerVO.getMobile();
		String password = registerVO.getPassword();
		
		//获取redis验证码
		String redisVerifyCode = redisTemplate.opsForValue().get(mobileNo);
		
		if(redisVerifyCode == null)
			throw new YzzException(201, "验证码已失效");
		
		if(!redisVerifyCode.equals(verfiyCode))
			throw new YzzException(201, "验证码错误，请重试");
		
		//判断手机号是否已经注册
		QueryWrapper<Member> qw = new QueryWrapper<>();
		qw.eq("mobile", mobileNo);
		int count = memberMapper.selectCount(qw);
		if(count == 0){
			Member memberInsert = new Member();
			//向memberInsert赋值
			BeanUtils.copyProperties(registerVO, memberInsert);
			memberInsert.setPassword(MD5.encrypt(password));
			memberInsert.setIsDisabled(false);
			if(memberMapper.insert(memberInsert) <= 0){
				throw new YzzException(201, "注册用户执行sql失败");
			}
		}else{
			throw new YzzException(201, "手机号已经绑定用户");
		}
		
		return true;
	}
	
	@Override
	public Member getInfoByToken(HttpServletRequest request) {
		String memberId = JwtUtils.getMemberIdByJwtToken(request);
		return memberMapper.selectById(memberId);
	}
	
}
