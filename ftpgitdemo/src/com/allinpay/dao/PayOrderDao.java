/*
 * 版权声明 .
 * 此文档的版权归通联支付股份有限公司所有
 * Powered By [AIPSEE-framework]
 */

package com.allinpay.dao;

import org.springframework.stereotype.Component;

import com.allinpay.model.PayOrder;
import com.allinpay.model.PayOrderPk;

import javacommon.base.BaseIbatisDao;

/**
 * PayOrderDao,持久层类 用于PayOrder 表的CRUD.
 * @author chenxh
 * @version 1.0
 * @since 1.0
 */

@Component
public class PayOrderDao extends BaseIbatisDao{
	/**
	 * 取得 PayOrder 对象 .
	 * @return PayOrder
	 */
	public Class getEntityClass() {
		return PayOrder.class;
	}
    
	public java.util.List<PayOrder> findAll(java.util.Map conditions){
		return getSqlMapClientTemplate().queryForList("PayOrder.select", conditions);
	}

}
