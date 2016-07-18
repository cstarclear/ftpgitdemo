/*
 * 版权声明 .
 * 此文档的版权归通联支付股份有限公司所有
 * Powered By [AIPSEE-framework]
 */

package com.allinpay.service;

import org.springframework.stereotype.Component;


import javacommon.base.BaseManager;
import javacommon.base.EntityDao;

import com.allinpay.dao.*;
import com.allinpay.model.PayOrder;

/**
 * PayOrder 的基本的业务流程逻辑的接口,实现业务流程的控制;继承了基本的CRUD方法.
 * @author chenxh
 * @version 1.0
 * @since 1.0
 */

@Component
public class PayOrderManager extends BaseManager{
	/** 变量 payOrderDao . */
	private PayOrderDao payOrderDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性*/
	public void setPayOrderDao(PayOrderDao dao) {
		this.payOrderDao = dao;
	}
	/**
	 * 取得 payOrderDao 的对象 .
	 * @return  payOrderDao
	 */
	public EntityDao getEntityDao() {
		return (EntityDao) this.payOrderDao;
	}

	public java.util.List<PayOrder> findAll(java.util.Map conditions){
		return payOrderDao.findAll(conditions);
	}
}
