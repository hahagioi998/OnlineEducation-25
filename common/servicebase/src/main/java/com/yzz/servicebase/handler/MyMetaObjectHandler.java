package com.yzz.servicebase.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
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
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "gmtCreate", Date.class, Calendar.getInstance().getTime());
		this.strictInsertFill(metaObject, "gmtModified", Date.class, Calendar.getInstance().getTime());
	}
	
	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject, "gmtModified", Date.class, Calendar.getInstance().getTime());
	}
}
