package com.yzz.service_cms.cms.service;

import com.yzz.service_cms.cms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author yky
 * @since 2021-01-12
 */
public interface CrmBannerService extends IService<CrmBanner> {
	
	/**
	 * 分页查询banner
	 * @param current
	 * @param pageSize
	 * @return
	 */
	HashMap<String, Object> queryByPages(int current, int pageSize);
	
	/**
	 * 增添banner
	 * @param crmBanner
	 * @return
	 */
	int addBanner(CrmBanner crmBanner);
	
	/**
	 * 删除banner
	 * @param bannerId
	 * @return
	 */
	int deleteBanner(String bannerId);
	
	/**
	 * 更新banner
	 * @param crmBanner
	 * @return
	 */
	int updateBanner(CrmBanner crmBanner);
	
	/**
	 * 根据id查询banner
	 * @param bannerId
	 * @return
	 */
	CrmBanner queryBannerById(String bannerId);
	
	/**
	 * 查询所有banner
	 * @return
	 */
	List<CrmBanner> getAllBanner();
}
