/*
 * 版权声明 .
 * 此文档的版权归通联支付股份有限公司所有
 * Powered By [AIPSEE-framework]
 */

package com.allinpay.model;

import javacommon.base.BaseEntity;

/**
 * PayOrderPk ,用于联合主键.
 * @author 请注明作者
 * @version 1.0
 * @since 1.0
 */

public class PayOrderPk extends BaseEntity {
	
	/** 变量  orderId . */
	private java.lang.String orderId;
	/** 变量  orderType . */
	private java.lang.String orderType;
	//key columns END
	/**
	* PayOrderPk  的构造函数 .
	*/
	public PayOrderPk() {
	}
	/**
	* PayOrderPk  的构造函数 .
	*/
	public PayOrderPk(
		java.lang.String orderId ,
		java.lang.String orderType 
	) {
		this.orderId = orderId;
		this.orderType = orderType;
	}

	
	/**
	* OrderId 置值 .
	* @param  java.lang.String
	*/	
	public void setOrderId(java.lang.String value) {
	this.orderId = value;
	}
	/**
	* OrderId 取值 .
	* @return java.lang.String
	*/
	public java.lang.String getOrderId() {
	return this.orderId;
	}
	/**
	* OrderType 置值 .
	* @param  java.lang.String
	*/	
	public void setOrderType(java.lang.String value) {
	this.orderType = value;
	}
	/**
	* OrderType 取值 .
	* @return java.lang.String
	*/
	public java.lang.String getOrderType() {
	return this.orderType;
	}


}



