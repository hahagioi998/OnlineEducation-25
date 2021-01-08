package com.yzz.servicebase.handler;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName MyMetaObjectHandler
 * @Author yky
 * @Date 2020/12/25
 * @Version 1.0
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		log.info("start autofill gmtCreate...");
		this.strictInsertFill(metaObject, "gmtCreate", Date.class, DateUtil.date());
		this.strictInsertFill(metaObject, "gmtModified", Date.class, DateUtil.date());
		this.strictInsertFill(metaObject, "isDeleted", Integer.class, 0);
		log.info("end autofill gmtCreate...");
	}
	
	@Override
	public void updateFill(MetaObject metaObject) {
		log.info("start autofill gmtModified...");
		this.strictUpdateFill(metaObject, "gmtModified", Date.class, DateUtil.date());
		log.info("end autofill gmtModified...");
	}
}
