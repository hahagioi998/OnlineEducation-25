package com.yzz.service_cms.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yzz.commonutils.exception.YzzException;
import com.yzz.service_cms.cms.entity.CrmBanner;
import com.yzz.service_cms.cms.mapper.CrmBannerMapper;
import com.yzz.service_cms.cms.service.CrmBannerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author yky
 * @since 2021-01-12
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {
	
	@Resource
	private CrmBannerMapper crmBannerMapper;
	
	@Override
	public HashMap<String, Object> queryByPages(int current, int pageSize) {
		PageHelper.startPage(current, pageSize);
		List<CrmBanner> bannerList = crmBannerMapper.selectList(new QueryWrapper<>());
		PageInfo<CrmBanner> pageInfo = new PageInfo<>(bannerList);
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("total", pageInfo.getTotal());
		hashMap.put("list", pageInfo.getList());
		return hashMap;
	}
	
	@Override
	public int addBanner(CrmBanner crmBanner) {
		int i = crmBannerMapper.insert(crmBanner);
		if(i <= 0)
			throw new YzzException(201, "增加banner失败");
		return i;
	}
	
	@Override
	public int deleteBanner(String bannerId) {
		int i = crmBannerMapper.deleteById(bannerId);
		if(i <= 0)
			throw new YzzException(201, "删除banner失败");
		return i;
	}
	
	@Override
	public int updateBanner(CrmBanner crmBanner) {
		int i =crmBannerMapper.updateById(crmBanner);
		if(i <= 0)
			throw new YzzException(201, "更新banner失败");
		return i;
	}
	
	@Override
	public CrmBanner queryBannerById(String bannerId) {
		return crmBannerMapper.selectById(bannerId);
	}
	
	@Override
	public List<CrmBanner> getAllBanner() {
		QueryWrapper<CrmBanner> qw = new QueryWrapper<>();
		qw.orderByDesc("id");
		//查询前两条记录
		qw.last("limit 2");
		return crmBannerMapper.selectList(qw);
	}
}
