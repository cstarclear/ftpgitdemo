/*
 * 版权声明 .
 * 此文档的版权归通联支付股份有限公司所有
 * Powered By [AIPSEE-framework]
 */

package com.allinpay.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javacommon.base.BaseEntity;

/**
 * PayOrder 的modle 用于封装与应用程序的业务逻辑相关的数据.
 * @author 请注明作者
 * @version 1.0
 * @since 1.0
 */

public class PayOrder extends BaseEntity {
	
	/**
	 * 表名: 支付单表 alias 用于页面显示对应中英文信息  .
	 */
	public static final String TABLE_ALIAS = "支付单表";
	/** 列 ORDER_ID 的对应中英文信息. */
	public static final String ALIAS_ORDER_ID = "订单号";
	/** 列 CREATE_TIME 的对应中英文信息. */
	public static final String ALIAS_CREATE_TIME = "订单创建时间";
	/** 列 REQUES_ID 的对应中英文信息. */
	public static final String ALIAS_REQUES_ID = "请求号";
	/** 列 TRANS_TIME 的对应中英文信息. */
	public static final String ALIAS_TRANS_TIME = "交易时间";
	/** 列 TRANS_AMOUNT 的对应中英文信息. */
	public static final String ALIAS_TRANS_AMOUNT = "交易金额";
	/** 列 SUCC_AMOUNT 的对应中英文信息. */
	public static final String ALIAS_SUCC_AMOUNT = "扣款金额";
	/** 列 CRY_TYPE 的对应中英文信息. */
	public static final String ALIAS_CRY_TYPE = "币种";
	/** 列 PAY_TYPE 的对应中英文信息. */
	public static final String ALIAS_PAY_TYPE = "支付类型";
	/** 列 STATUS 的对应中英文信息. */
	public static final String ALIAS_STATUS = "交易状态";
	/** 列 ORDER_CHNL 的对应中英文信息. */
	public static final String ALIAS_ORDER_CHNL = "业务渠道";
	/** 列 ORDER_TYPE 的对应中英文信息. */
	public static final String ALIAS_ORDER_TYPE = "业务类型";
	/** 列 TRADE_MODE 的对应中英文信息. */
	public static final String ALIAS_TRADE_MODE = "交易模式";
	/** 列 TRADE_TYPE 的对应中英文信息. */
	public static final String ALIAS_TRADE_TYPE = "交易类型";
	/** 列 ORDER_FROM 的对应中英文信息. */
	public static final String ALIAS_ORDER_FROM = "订单来源";
	/** 列 PAY_CUST_USER_ID 的对应中英文信息. */
	public static final String ALIAS_PAY_CUST_USER_ID = "支付方用户号";
	/** 列 PAY_CUST_NAME 的对应中英文信息. */
	public static final String ALIAS_PAY_CUST_NAME = "支付方名称";
	/** 列 PAY_CUST_ACCT 的对应中英文信息. */
	public static final String ALIAS_PAY_CUST_ACCT = "支付方账号";
	/** 列 PAY_CUST_CARD_NO 的对应中英文信息. */
	public static final String ALIAS_PAY_CUST_CARD_NO = "支付卡号";
	/** 列 COL_CUST_USER_ID 的对应中英文信息. */
	public static final String ALIAS_COL_CUST_USER_ID = "收款方用户号";
	/** 列 COL_CUST_NAME 的对应中英文信息. */
	public static final String ALIAS_COL_CUST_NAME = "收款方名称";
	/** 列 COL_CUST_ACCT 的对应中英文信息. */
	public static final String ALIAS_COL_CUST_ACCT = "收款方账号";
	/** 列 COL_CUST_CARD_NO 的对应中英文信息. */
	public static final String ALIAS_COL_CUST_CARD_NO = "收款卡号";
	/** 列 TRADE_NO 的对应中英文信息. */
	public static final String ALIAS_TRADE_NO = "交易商品号";
	/** 列 TARDE_NAME 的对应中英文信息. */
	public static final String ALIAS_TARDE_NAME = "交易商品名称";
	/** 列 EXT_ORDER_NO 的对应中英文信息. */
	public static final String ALIAS_EXT_ORDER_NO = "外部订单号";
	/** 列 FROZEN_AMOUNT 的对应中英文信息. */
	public static final String ALIAS_FROZEN_AMOUNT = "冻结金额";
	/** 列 FROZEN_TIME 的对应中英文信息. */
	public static final String ALIAS_FROZEN_TIME = "冻结时间";
	/** 列 REFUND_TIME 的对应中英文信息. */
	public static final String ALIAS_REFUND_TIME = "退款时间";
	/** 列 REFUND_AMOUNT 的对应中英文信息. */
	public static final String ALIAS_REFUND_AMOUNT = "退款金额";
	/** 列 REFUND_TIMES 的对应中英文信息. */
	public static final String ALIAS_REFUND_TIMES = "退款次数";
	/** 列 COMAMT 的对应中英文信息. */
	public static final String ALIAS_COMAMT = "手续费";
	/** 列 OPER_NO 的对应中英文信息. */
	public static final String ALIAS_OPER_NO = "操作编号(付款方+收款方+时间+金额匹配)";
	/** 列 BACK_UP 的对应中英文信息. */
	public static final String ALIAS_BACK_UP = "备用字段";
	/** 列 LAST_UPDATE_TIME 的对应中英文信息. */
	public static final String ALIAS_LAST_UPDATE_TIME = "最后更新时间";
	/** 列 LAST_STATUS 的对应中英文信息. */
	public static final String ALIAS_LAST_STATUS = "最后更新状态";
	/** 列 IP_ADDR 的对应中英文信息. */
	public static final String ALIAS_IP_ADDR = "IP地址";
	/** 列 TRANS_PASSWORD 的对应中英文信息. */
	public static final String ALIAS_TRANS_PASSWORD = "00:有密，01:无密";
	/** 列 PAY_CARD_ISS_CODE 的对应中英文信息. */
	public static final String ALIAS_PAY_CARD_ISS_CODE = "发卡行代码";
	/** 列 PAY_CARD_ISS_DSP 的对应中英文信息. */
	public static final String ALIAS_PAY_CARD_ISS_DSP = "发卡行名称";
	/** 列 COL_CARD_ISS_CODE 的对应中英文信息. */
	public static final String ALIAS_COL_CARD_ISS_CODE = "收款卡发卡行代码";
	/** 列 COL_CARD_ISS_DSP 的对应中英文信息. */
	public static final String ALIAS_COL_CARD_ISS_DSP = "收款卡发卡行名称";
	/** 列 PAY_CARD_TYPE 的对应中英文信息. */
	public static final String ALIAS_PAY_CARD_TYPE = "付款卡类型";
	/** 列 COL_CARD_TYPE 的对应中英文信息. */
	public static final String ALIAS_COL_CARD_TYPE = "收款卡类型";
	/** 列 COMPANY_ID 的对应中英文信息. */
	public static final String ALIAS_COMPANY_ID = "所属分公司";
	/** 列 PAY_CUSTOMER_URL 的对应中英文信息. */
	public static final String ALIAS_PAY_CUSTOMER_URL = "付款客户的取货url地址";
	/** 列 SERVER_URL 的对应中英文信息. */
	public static final String ALIAS_SERVER_URL = "服务器接受支付结果的后台地址";
	/** 列 TERM_CODE 的对应中英文信息. */
	public static final String ALIAS_TERM_CODE = "终端号";
	/** 列 REFERENCE_NO 的对应中英文信息. */
	public static final String ALIAS_REFERENCE_NO = "检索参考号";
	/** 列 SYS_TRACE_NO 的对应中英文信息. */
	public static final String ALIAS_SYS_TRACE_NO = "系统跟踪号";
	/** 列 ALLINPAY_ORDER_ID 的对应中英文信息. */
	public static final String ALIAS_ALLINPAY_ORDER_ID = "通联订单号";
	/** 列 SOID 的对应中英文信息. */
	public static final String ALIAS_SOID = "订单编号";
	/** 列 FILE_NAME 的对应中英文信息. */
	public static final String ALIAS_FILE_NAME = "文件名";
	/** 列 APS_SEQUENCE 的对应中英文信息. */
	public static final String ALIAS_APS_SEQUENCE = "APS流水";
	/** 列 WITHDRAW_SEQUENCE 的对应中英文信息. */
	public static final String ALIAS_WITHDRAW_SEQUENCE = "撤销流水号";
	/** 列 REVERSE_SEQUENCE 的对应中英文信息. */
	public static final String ALIAS_REVERSE_SEQUENCE = "冲正流水号";
	/** 列 INNER_CODE 的对应中英文信息. */
	public static final String ALIAS_INNER_CODE = "内部应答码";
	/** 列 DEAL_RESULT 的对应中英文信息. */
	public static final String ALIAS_DEAL_RESULT = "处理结果";
	/** 列 CASH_PAY 的对应中英文信息. */
	public static final String ALIAS_CASH_PAY = "支付现金总额";
	/** 列 PACKAGE_ID 的对应中英文信息. */
	public static final String ALIAS_PACKAGE_ID = "运单号";
	/** 列 ORDER_NO 的对应中英文信息. */
	public static final String ALIAS_ORDER_NO = "商户订单号(收单，网关)";
	/** 列 PAYER_REFERRER_URL 的对应中英文信息. */
	public static final String ALIAS_PAYER_REFERRER_URL = "payerReferrerUrl";
	/** 列 CARD_BIN 的对应中英文信息. */
	public static final String ALIAS_CARD_BIN = "卡BIN";
	/** 列 AUTH_CODE 的对应中英文信息. */
	public static final String ALIAS_AUTH_CODE = "授权标识应答码(授权号)";
	/** 列 RETURN_CODE 的对应中英文信息. */
	public static final String ALIAS_RETURN_CODE = "应答码(受理)";
	
	//date formats
	/** 变量 CREATE_TIME . */
	public static final String FORMAT_CREATE_TIME = DATE_TIME_FORMAT;
	/** 变量 TRANS_TIME . */
	public static final String FORMAT_TRANS_TIME = DATE_TIME_FORMAT;
	/** 变量 FROZEN_TIME . */
	public static final String FORMAT_FROZEN_TIME = DATE_TIME_FORMAT;
	/** 变量 REFUND_TIME . */
	public static final String FORMAT_REFUND_TIME = DATE_TIME_FORMAT;
	/** 变量 LAST_UPDATE_TIME . */
	public static final String FORMAT_LAST_UPDATE_TIME = DATE_TIME_FORMAT;
	
	//columns START
	/** 变量 orderId . */
	private java.lang.String orderId;
	/** 变量 createTime . */
	private java.sql.Timestamp createTime;
	/** 变量 requesId . */
	private java.lang.String requesId;
	/** 变量 transTime . */
	private java.sql.Timestamp transTime;
	/** 变量 transAmount . */
	private java.lang.Long transAmount;
	/** 变量 succAmount . */
	private java.lang.Long succAmount;
	/** 变量 cryType . */
	private java.lang.String cryType;
	/** 变量 payType . */
	private java.lang.String payType;
	/** 变量 status . */
	private java.lang.String status;
	/** 变量 orderChnl . */
	private java.lang.String orderChnl;
	/** 变量 orderType . */
	private java.lang.String orderType;
	/** 变量 tradeMode . */
	private java.lang.String tradeMode;
	/** 变量 tradeType . */
	private java.lang.String tradeType;
	/** 变量 orderFrom . */
	private java.lang.String orderFrom;
	/** 变量 payCustUserId . */
	private java.lang.String payCustUserId;
	/** 变量 payCustName . */
	private java.lang.String payCustName;
	/** 变量 payCustAcct . */
	private java.lang.String payCustAcct;
	/** 变量 payCustCardNo . */
	private java.lang.String payCustCardNo;
	/** 变量 colCustUserId . */
	private java.lang.String colCustUserId;
	/** 变量 colCustName . */
	private java.lang.String colCustName;
	/** 变量 colCustAcct . */
	private java.lang.String colCustAcct;
	/** 变量 colCustCardNo . */
	private java.lang.String colCustCardNo;
	/** 变量 tradeNo . */
	private java.lang.String tradeNo;
	/** 变量 tardeName . */
	private java.lang.String tardeName;
	/** 变量 extOrderNo . */
	private java.lang.String extOrderNo;
	/** 变量 frozenAmount . */
	private java.lang.Long frozenAmount;
	/** 变量 frozenTime . */
	private java.sql.Timestamp frozenTime;
	/** 变量 refundTime . */
	private java.sql.Timestamp refundTime;
	/** 变量 refundAmount . */
	private java.lang.Long refundAmount;
	/** 变量 refundTimes . */
	private java.lang.Long refundTimes;
	/** 变量 comamt . */
	private java.lang.Long comamt;
	/** 变量 operNo . */
	private java.lang.String operNo;
	/** 变量 backUp . */
	private java.lang.String backUp;
	/** 变量 lastUpdateTime . */
	private java.sql.Timestamp lastUpdateTime;
	/** 变量 lastStatus . */
	private java.lang.String lastStatus;
	/** 变量 ipAddr . */
	private java.lang.String ipAddr;
	/** 变量 transPassword . */
	private java.lang.String transPassword;
	/** 变量 payCardIssCode . */
	private java.lang.String payCardIssCode;
	/** 变量 payCardIssDsp . */
	private java.lang.String payCardIssDsp;
	/** 变量 colCardIssCode . */
	private java.lang.String colCardIssCode;
	/** 变量 colCardIssDsp . */
	private java.lang.String colCardIssDsp;
	/** 变量 payCardType . */
	private java.lang.String payCardType;
	/** 变量 colCardType . */
	private java.lang.String colCardType;
	/** 变量 companyId . */
	private java.lang.String companyId;
	/** 变量 payCustomerUrl . */
	private java.lang.String payCustomerUrl;
	/** 变量 serverUrl . */
	private java.lang.String serverUrl;
	/** 变量 termCode . */
	private java.lang.String termCode;
	/** 变量 referenceNo . */
	private java.lang.String referenceNo;
	/** 变量 sysTraceNo . */
	private java.lang.String sysTraceNo;
	/** 变量 allinpayOrderId . */
	private java.lang.String allinpayOrderId;
	/** 变量 soid . */
	private java.lang.String soid;
	/** 变量 fileName . */
	private java.lang.String fileName;
	/** 变量 apsSequence . */
	private java.lang.String apsSequence;
	/** 变量 withdrawSequence . */
	private java.lang.String withdrawSequence;
	/** 变量 reverseSequence . */
	private java.lang.String reverseSequence;
	/** 变量 innerCode . */
	private java.lang.String innerCode;
	/** 变量 dealResult . */
	private java.lang.String dealResult;
	/** 变量 cashPay . */
	private java.lang.String cashPay;
	/** 变量 packageId . */
	private java.lang.String packageId;
	/** 变量 orderNo . */
	private java.lang.String orderNo;
	/** 变量 payerReferrerUrl . */
	private java.lang.String payerReferrerUrl;
	/** 变量 cardBin . */
	private java.lang.String cardBin;
	/** 变量 authCode . */
	private java.lang.String authCode;
	/** 变量 returnCode . */
	private java.lang.String returnCode;
	//columns END

	/**
	* PayOrder 的构造函数
	*/
	public PayOrder() {
	}
	/**
	* PayOrder 的构造函数
	*/
	public PayOrder(
		java.lang.String orderId,
		java.lang.String orderType
	) {
		this.orderId = orderId;
		this.orderType = orderType;
	}

	/**
	 * OrderId 置值.
	 * @param  java.lang.String
	 */	
	public void setOrderId(java.lang.String value) {
		this.orderId = value;
	}
	/**
	 * OrderId 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getOrderId() {
		return this.orderId;
	}
	/**
	 * CreateTime 取值.
	 * @return java.sql.Timestamp
	 */	
	public String getCreateTimeString() {
		return date2String(getCreateTime(), FORMAT_CREATE_TIME);
	}
	/**
	 * CreateTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setCreateTimeString(String value) {
		setCreateTime(string2Date(value, FORMAT_CREATE_TIME,java.sql.Timestamp.class));
	}
	
	/**
	 * CreateTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	/**
	 * CreateTime 取值.
	 * @return java.sql.Timestamp
	 */
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	/**
	 * RequesId 置值.
	 * @param  java.lang.String
	 */	
	public void setRequesId(java.lang.String value) {
		this.requesId = value;
	}
	/**
	 * RequesId 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getRequesId() {
		return this.requesId;
	}
	/**
	 * TransTime 取值.
	 * @return java.sql.Timestamp
	 */	
	public String getTransTimeString() {
		return date2String(getTransTime(), FORMAT_TRANS_TIME);
	}
	/**
	 * TransTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setTransTimeString(String value) {
		setTransTime(string2Date(value, FORMAT_TRANS_TIME,java.sql.Timestamp.class));
	}
	
	/**
	 * TransTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setTransTime(java.sql.Timestamp value) {
		this.transTime = value;
	}
	/**
	 * TransTime 取值.
	 * @return java.sql.Timestamp
	 */
	public java.sql.Timestamp getTransTime() {
		return this.transTime;
	}
	/**
	 * TransAmount 置值.
	 * @param  java.lang.Long
	 */	
	public void setTransAmount(java.lang.Long value) {
		this.transAmount = value;
	}
	/**
	 * TransAmount 取值.
	 * @return java.lang.Long
	 */
	public java.lang.Long getTransAmount() {
		return this.transAmount;
	}
	/**
	 * SuccAmount 置值.
	 * @param  java.lang.Long
	 */	
	public void setSuccAmount(java.lang.Long value) {
		this.succAmount = value;
	}
	/**
	 * SuccAmount 取值.
	 * @return java.lang.Long
	 */
	public java.lang.Long getSuccAmount() {
		return this.succAmount;
	}
	/**
	 * CryType 置值.
	 * @param  java.lang.String
	 */	
	public void setCryType(java.lang.String value) {
		this.cryType = value;
	}
	/**
	 * CryType 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getCryType() {
		return this.cryType;
	}
	/**
	 * PayType 置值.
	 * @param  java.lang.String
	 */	
	public void setPayType(java.lang.String value) {
		this.payType = value;
	}
	/**
	 * PayType 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayType() {
		return this.payType;
	}
	/**
	 * Status 置值.
	 * @param  java.lang.String
	 */	
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	/**
	 * Status 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
	/**
	 * OrderChnl 置值.
	 * @param  java.lang.String
	 */	
	public void setOrderChnl(java.lang.String value) {
		this.orderChnl = value;
	}
	/**
	 * OrderChnl 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getOrderChnl() {
		return this.orderChnl;
	}
	/**
	 * OrderType 置值.
	 * @param  java.lang.String
	 */	
	public void setOrderType(java.lang.String value) {
		this.orderType = value;
	}
	/**
	 * OrderType 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getOrderType() {
		return this.orderType;
	}
	/**
	 * TradeMode 置值.
	 * @param  java.lang.String
	 */	
	public void setTradeMode(java.lang.String value) {
		this.tradeMode = value;
	}
	/**
	 * TradeMode 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getTradeMode() {
		return this.tradeMode;
	}
	/**
	 * TradeType 置值.
	 * @param  java.lang.String
	 */	
	public void setTradeType(java.lang.String value) {
		this.tradeType = value;
	}
	/**
	 * TradeType 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getTradeType() {
		return this.tradeType;
	}
	/**
	 * OrderFrom 置值.
	 * @param  java.lang.String
	 */	
	public void setOrderFrom(java.lang.String value) {
		this.orderFrom = value;
	}
	/**
	 * OrderFrom 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getOrderFrom() {
		return this.orderFrom;
	}
	/**
	 * PayCustUserId 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCustUserId(java.lang.String value) {
		this.payCustUserId = value;
	}
	/**
	 * PayCustUserId 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCustUserId() {
		return this.payCustUserId;
	}
	/**
	 * PayCustName 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCustName(java.lang.String value) {
		this.payCustName = value;
	}
	/**
	 * PayCustName 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCustName() {
		return this.payCustName;
	}
	/**
	 * PayCustAcct 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCustAcct(java.lang.String value) {
		this.payCustAcct = value;
	}
	/**
	 * PayCustAcct 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCustAcct() {
		return this.payCustAcct;
	}
	/**
	 * PayCustCardNo 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCustCardNo(java.lang.String value) {
		this.payCustCardNo = value;
	}
	/**
	 * PayCustCardNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCustCardNo() {
		return this.payCustCardNo;
	}
	/**
	 * ColCustUserId 置值.
	 * @param  java.lang.String
	 */	
	public void setColCustUserId(java.lang.String value) {
		this.colCustUserId = value;
	}
	/**
	 * ColCustUserId 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getColCustUserId() {
		return this.colCustUserId;
	}
	/**
	 * ColCustName 置值.
	 * @param  java.lang.String
	 */	
	public void setColCustName(java.lang.String value) {
		this.colCustName = value;
	}
	/**
	 * ColCustName 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getColCustName() {
		return this.colCustName;
	}
	/**
	 * ColCustAcct 置值.
	 * @param  java.lang.String
	 */	
	public void setColCustAcct(java.lang.String value) {
		this.colCustAcct = value;
	}
	/**
	 * ColCustAcct 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getColCustAcct() {
		return this.colCustAcct;
	}
	/**
	 * ColCustCardNo 置值.
	 * @param  java.lang.String
	 */	
	public void setColCustCardNo(java.lang.String value) {
		this.colCustCardNo = value;
	}
	/**
	 * ColCustCardNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getColCustCardNo() {
		return this.colCustCardNo;
	}
	/**
	 * TradeNo 置值.
	 * @param  java.lang.String
	 */	
	public void setTradeNo(java.lang.String value) {
		this.tradeNo = value;
	}
	/**
	 * TradeNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getTradeNo() {
		return this.tradeNo;
	}
	/**
	 * TardeName 置值.
	 * @param  java.lang.String
	 */	
	public void setTardeName(java.lang.String value) {
		this.tardeName = value;
	}
	/**
	 * TardeName 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getTardeName() {
		return this.tardeName;
	}
	/**
	 * ExtOrderNo 置值.
	 * @param  java.lang.String
	 */	
	public void setExtOrderNo(java.lang.String value) {
		this.extOrderNo = value;
	}
	/**
	 * ExtOrderNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getExtOrderNo() {
		return this.extOrderNo;
	}
	/**
	 * FrozenAmount 置值.
	 * @param  java.lang.Long
	 */	
	public void setFrozenAmount(java.lang.Long value) {
		this.frozenAmount = value;
	}
	/**
	 * FrozenAmount 取值.
	 * @return java.lang.Long
	 */
	public java.lang.Long getFrozenAmount() {
		return this.frozenAmount;
	}
	/**
	 * FrozenTime 取值.
	 * @return java.sql.Timestamp
	 */	
	public String getFrozenTimeString() {
		return date2String(getFrozenTime(), FORMAT_FROZEN_TIME);
	}
	/**
	 * FrozenTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setFrozenTimeString(String value) {
		setFrozenTime(string2Date(value, FORMAT_FROZEN_TIME,java.sql.Timestamp.class));
	}
	
	/**
	 * FrozenTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setFrozenTime(java.sql.Timestamp value) {
		this.frozenTime = value;
	}
	/**
	 * FrozenTime 取值.
	 * @return java.sql.Timestamp
	 */
	public java.sql.Timestamp getFrozenTime() {
		return this.frozenTime;
	}
	/**
	 * RefundTime 取值.
	 * @return java.sql.Timestamp
	 */	
	public String getRefundTimeString() {
		return date2String(getRefundTime(), FORMAT_REFUND_TIME);
	}
	/**
	 * RefundTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setRefundTimeString(String value) {
		setRefundTime(string2Date(value, FORMAT_REFUND_TIME,java.sql.Timestamp.class));
	}
	
	/**
	 * RefundTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setRefundTime(java.sql.Timestamp value) {
		this.refundTime = value;
	}
	/**
	 * RefundTime 取值.
	 * @return java.sql.Timestamp
	 */
	public java.sql.Timestamp getRefundTime() {
		return this.refundTime;
	}
	/**
	 * RefundAmount 置值.
	 * @param  java.lang.Long
	 */	
	public void setRefundAmount(java.lang.Long value) {
		this.refundAmount = value;
	}
	/**
	 * RefundAmount 取值.
	 * @return java.lang.Long
	 */
	public java.lang.Long getRefundAmount() {
		return this.refundAmount;
	}
	/**
	 * RefundTimes 置值.
	 * @param  java.lang.Long
	 */	
	public void setRefundTimes(java.lang.Long value) {
		this.refundTimes = value;
	}
	/**
	 * RefundTimes 取值.
	 * @return java.lang.Long
	 */
	public java.lang.Long getRefundTimes() {
		return this.refundTimes;
	}
	/**
	 * Comamt 置值.
	 * @param  java.lang.Long
	 */	
	public void setComamt(java.lang.Long value) {
		this.comamt = value;
	}
	/**
	 * Comamt 取值.
	 * @return java.lang.Long
	 */
	public java.lang.Long getComamt() {
		return this.comamt;
	}
	/**
	 * OperNo 置值.
	 * @param  java.lang.String
	 */	
	public void setOperNo(java.lang.String value) {
		this.operNo = value;
	}
	/**
	 * OperNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getOperNo() {
		return this.operNo;
	}
	/**
	 * BackUp 置值.
	 * @param  java.lang.String
	 */	
	public void setBackUp(java.lang.String value) {
		this.backUp = value;
	}
	/**
	 * BackUp 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getBackUp() {
		return this.backUp;
	}
	/**
	 * LastUpdateTime 取值.
	 * @return java.sql.Timestamp
	 */	
	public String getLastUpdateTimeString() {
		return date2String(getLastUpdateTime(), FORMAT_LAST_UPDATE_TIME);
	}
	/**
	 * LastUpdateTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setLastUpdateTimeString(String value) {
		setLastUpdateTime(string2Date(value, FORMAT_LAST_UPDATE_TIME,java.sql.Timestamp.class));
	}
	
	/**
	 * LastUpdateTime 置值.
	 * @param  java.sql.Timestamp
	 */	
	public void setLastUpdateTime(java.sql.Timestamp value) {
		this.lastUpdateTime = value;
	}
	/**
	 * LastUpdateTime 取值.
	 * @return java.sql.Timestamp
	 */
	public java.sql.Timestamp getLastUpdateTime() {
		return this.lastUpdateTime;
	}
	/**
	 * LastStatus 置值.
	 * @param  java.lang.String
	 */	
	public void setLastStatus(java.lang.String value) {
		this.lastStatus = value;
	}
	/**
	 * LastStatus 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getLastStatus() {
		return this.lastStatus;
	}
	/**
	 * IpAddr 置值.
	 * @param  java.lang.String
	 */	
	public void setIpAddr(java.lang.String value) {
		this.ipAddr = value;
	}
	/**
	 * IpAddr 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getIpAddr() {
		return this.ipAddr;
	}
	/**
	 * TransPassword 置值.
	 * @param  java.lang.String
	 */	
	public void setTransPassword(java.lang.String value) {
		this.transPassword = value;
	}
	/**
	 * TransPassword 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getTransPassword() {
		return this.transPassword;
	}
	/**
	 * PayCardIssCode 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCardIssCode(java.lang.String value) {
		this.payCardIssCode = value;
	}
	/**
	 * PayCardIssCode 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCardIssCode() {
		return this.payCardIssCode;
	}
	/**
	 * PayCardIssDsp 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCardIssDsp(java.lang.String value) {
		this.payCardIssDsp = value;
	}
	/**
	 * PayCardIssDsp 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCardIssDsp() {
		return this.payCardIssDsp;
	}
	/**
	 * ColCardIssCode 置值.
	 * @param  java.lang.String
	 */	
	public void setColCardIssCode(java.lang.String value) {
		this.colCardIssCode = value;
	}
	/**
	 * ColCardIssCode 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getColCardIssCode() {
		return this.colCardIssCode;
	}
	/**
	 * ColCardIssDsp 置值.
	 * @param  java.lang.String
	 */	
	public void setColCardIssDsp(java.lang.String value) {
		this.colCardIssDsp = value;
	}
	/**
	 * ColCardIssDsp 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getColCardIssDsp() {
		return this.colCardIssDsp;
	}
	/**
	 * PayCardType 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCardType(java.lang.String value) {
		this.payCardType = value;
	}
	/**
	 * PayCardType 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCardType() {
		return this.payCardType;
	}
	/**
	 * ColCardType 置值.
	 * @param  java.lang.String
	 */	
	public void setColCardType(java.lang.String value) {
		this.colCardType = value;
	}
	/**
	 * ColCardType 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getColCardType() {
		return this.colCardType;
	}
	/**
	 * CompanyId 置值.
	 * @param  java.lang.String
	 */	
	public void setCompanyId(java.lang.String value) {
		this.companyId = value;
	}
	/**
	 * CompanyId 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getCompanyId() {
		return this.companyId;
	}
	/**
	 * PayCustomerUrl 置值.
	 * @param  java.lang.String
	 */	
	public void setPayCustomerUrl(java.lang.String value) {
		this.payCustomerUrl = value;
	}
	/**
	 * PayCustomerUrl 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayCustomerUrl() {
		return this.payCustomerUrl;
	}
	/**
	 * ServerUrl 置值.
	 * @param  java.lang.String
	 */	
	public void setServerUrl(java.lang.String value) {
		this.serverUrl = value;
	}
	/**
	 * ServerUrl 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getServerUrl() {
		return this.serverUrl;
	}
	/**
	 * TermCode 置值.
	 * @param  java.lang.String
	 */	
	public void setTermCode(java.lang.String value) {
		this.termCode = value;
	}
	/**
	 * TermCode 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getTermCode() {
		return this.termCode;
	}
	/**
	 * ReferenceNo 置值.
	 * @param  java.lang.String
	 */	
	public void setReferenceNo(java.lang.String value) {
		this.referenceNo = value;
	}
	/**
	 * ReferenceNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getReferenceNo() {
		return this.referenceNo;
	}
	/**
	 * SysTraceNo 置值.
	 * @param  java.lang.String
	 */	
	public void setSysTraceNo(java.lang.String value) {
		this.sysTraceNo = value;
	}
	/**
	 * SysTraceNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getSysTraceNo() {
		return this.sysTraceNo;
	}
	/**
	 * AllinpayOrderId 置值.
	 * @param  java.lang.String
	 */	
	public void setAllinpayOrderId(java.lang.String value) {
		this.allinpayOrderId = value;
	}
	/**
	 * AllinpayOrderId 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getAllinpayOrderId() {
		return this.allinpayOrderId;
	}
	/**
	 * Soid 置值.
	 * @param  java.lang.String
	 */	
	public void setSoid(java.lang.String value) {
		this.soid = value;
	}
	/**
	 * Soid 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getSoid() {
		return this.soid;
	}
	/**
	 * FileName 置值.
	 * @param  java.lang.String
	 */	
	public void setFileName(java.lang.String value) {
		this.fileName = value;
	}
	/**
	 * FileName 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getFileName() {
		return this.fileName;
	}
	/**
	 * ApsSequence 置值.
	 * @param  java.lang.String
	 */	
	public void setApsSequence(java.lang.String value) {
		this.apsSequence = value;
	}
	/**
	 * ApsSequence 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getApsSequence() {
		return this.apsSequence;
	}
	/**
	 * WithdrawSequence 置值.
	 * @param  java.lang.String
	 */	
	public void setWithdrawSequence(java.lang.String value) {
		this.withdrawSequence = value;
	}
	/**
	 * WithdrawSequence 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getWithdrawSequence() {
		return this.withdrawSequence;
	}
	/**
	 * ReverseSequence 置值.
	 * @param  java.lang.String
	 */	
	public void setReverseSequence(java.lang.String value) {
		this.reverseSequence = value;
	}
	/**
	 * ReverseSequence 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getReverseSequence() {
		return this.reverseSequence;
	}
	/**
	 * InnerCode 置值.
	 * @param  java.lang.String
	 */	
	public void setInnerCode(java.lang.String value) {
		this.innerCode = value;
	}
	/**
	 * InnerCode 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getInnerCode() {
		return this.innerCode;
	}
	/**
	 * DealResult 置值.
	 * @param  java.lang.String
	 */	
	public void setDealResult(java.lang.String value) {
		this.dealResult = value;
	}
	/**
	 * DealResult 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getDealResult() {
		return this.dealResult;
	}
	/**
	 * CashPay 置值.
	 * @param  java.lang.String
	 */	
	public void setCashPay(java.lang.String value) {
		this.cashPay = value;
	}
	/**
	 * CashPay 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getCashPay() {
		return this.cashPay;
	}
	/**
	 * PackageId 置值.
	 * @param  java.lang.String
	 */	
	public void setPackageId(java.lang.String value) {
		this.packageId = value;
	}
	/**
	 * PackageId 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPackageId() {
		return this.packageId;
	}
	/**
	 * OrderNo 置值.
	 * @param  java.lang.String
	 */	
	public void setOrderNo(java.lang.String value) {
		this.orderNo = value;
	}
	/**
	 * OrderNo 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	/**
	 * PayerReferrerUrl 置值.
	 * @param  java.lang.String
	 */	
	public void setPayerReferrerUrl(java.lang.String value) {
		this.payerReferrerUrl = value;
	}
	/**
	 * PayerReferrerUrl 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getPayerReferrerUrl() {
		return this.payerReferrerUrl;
	}
	/**
	 * CardBin 置值.
	 * @param  java.lang.String
	 */	
	public void setCardBin(java.lang.String value) {
		this.cardBin = value;
	}
	/**
	 * CardBin 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getCardBin() {
		return this.cardBin;
	}
	/**
	 * AuthCode 置值.
	 * @param  java.lang.String
	 */	
	public void setAuthCode(java.lang.String value) {
		this.authCode = value;
	}
	/**
	 * AuthCode 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getAuthCode() {
		return this.authCode;
	}
	/**
	 * ReturnCode 置值.
	 * @param  java.lang.String
	 */	
	public void setReturnCode(java.lang.String value) {
		this.returnCode = value;
	}
	/**
	 * ReturnCode 取值.
	 * @return java.lang.String
	 */
	public java.lang.String getReturnCode() {
		return this.returnCode;
	}
	/**
	 * 列值转换为String .
	 * @return String 列字符串
	 */
	public String toString() {
		return new ToStringBuilder(this)
			.append("OrderId", getOrderId())
			.append("CreateTime", getCreateTime())
			.append("RequesId", getRequesId())
			.append("TransTime", getTransTime())
			.append("TransAmount", getTransAmount())
			.append("SuccAmount", getSuccAmount())
			.append("CryType", getCryType())
			.append("PayType", getPayType())
			.append("Status", getStatus())
			.append("OrderChnl", getOrderChnl())
			.append("OrderType", getOrderType())
			.append("TradeMode", getTradeMode())
			.append("TradeType", getTradeType())
			.append("OrderFrom", getOrderFrom())
			.append("PayCustUserId", getPayCustUserId())
			.append("PayCustName", getPayCustName())
			.append("PayCustAcct", getPayCustAcct())
			.append("PayCustCardNo", getPayCustCardNo())
			.append("ColCustUserId", getColCustUserId())
			.append("ColCustName", getColCustName())
			.append("ColCustAcct", getColCustAcct())
			.append("ColCustCardNo", getColCustCardNo())
			.append("TradeNo", getTradeNo())
			.append("TardeName", getTardeName())
			.append("ExtOrderNo", getExtOrderNo())
			.append("FrozenAmount", getFrozenAmount())
			.append("FrozenTime", getFrozenTime())
			.append("RefundTime", getRefundTime())
			.append("RefundAmount", getRefundAmount())
			.append("RefundTimes", getRefundTimes())
			.append("Comamt", getComamt())
			.append("OperNo", getOperNo())
			.append("BackUp", getBackUp())
			.append("LastUpdateTime", getLastUpdateTime())
			.append("LastStatus", getLastStatus())
			.append("IpAddr", getIpAddr())
			.append("TransPassword", getTransPassword())
			.append("PayCardIssCode", getPayCardIssCode())
			.append("PayCardIssDsp", getPayCardIssDsp())
			.append("ColCardIssCode", getColCardIssCode())
			.append("ColCardIssDsp", getColCardIssDsp())
			.append("PayCardType", getPayCardType())
			.append("ColCardType", getColCardType())
			.append("CompanyId", getCompanyId())
			.append("PayCustomerUrl", getPayCustomerUrl())
			.append("ServerUrl", getServerUrl())
			.append("TermCode", getTermCode())
			.append("ReferenceNo", getReferenceNo())
			.append("SysTraceNo", getSysTraceNo())
			.append("AllinpayOrderId", getAllinpayOrderId())
			.append("Soid", getSoid())
			.append("FileName", getFileName())
			.append("ApsSequence", getApsSequence())
			.append("WithdrawSequence", getWithdrawSequence())
			.append("ReverseSequence", getReverseSequence())
			.append("InnerCode", getInnerCode())
			.append("DealResult", getDealResult())
			.append("CashPay", getCashPay())
			.append("PackageId", getPackageId())
			.append("OrderNo", getOrderNo())
			.append("PayerReferrerUrl", getPayerReferrerUrl())
			.append("CardBin", getCardBin())
			.append("AuthCode", getAuthCode())
			.append("ReturnCode", getReturnCode())
			.toString();
	}
	/**
	 * 列值转换为hashCode .
	 * @return int hashCode
	 */
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getOrderId())
			.append(getCreateTime())
			.append(getRequesId())
			.append(getTransTime())
			.append(getTransAmount())
			.append(getSuccAmount())
			.append(getCryType())
			.append(getPayType())
			.append(getStatus())
			.append(getOrderChnl())
			.append(getOrderType())
			.append(getTradeMode())
			.append(getTradeType())
			.append(getOrderFrom())
			.append(getPayCustUserId())
			.append(getPayCustName())
			.append(getPayCustAcct())
			.append(getPayCustCardNo())
			.append(getColCustUserId())
			.append(getColCustName())
			.append(getColCustAcct())
			.append(getColCustCardNo())
			.append(getTradeNo())
			.append(getTardeName())
			.append(getExtOrderNo())
			.append(getFrozenAmount())
			.append(getFrozenTime())
			.append(getRefundTime())
			.append(getRefundAmount())
			.append(getRefundTimes())
			.append(getComamt())
			.append(getOperNo())
			.append(getBackUp())
			.append(getLastUpdateTime())
			.append(getLastStatus())
			.append(getIpAddr())
			.append(getTransPassword())
			.append(getPayCardIssCode())
			.append(getPayCardIssDsp())
			.append(getColCardIssCode())
			.append(getColCardIssDsp())
			.append(getPayCardType())
			.append(getColCardType())
			.append(getCompanyId())
			.append(getPayCustomerUrl())
			.append(getServerUrl())
			.append(getTermCode())
			.append(getReferenceNo())
			.append(getSysTraceNo())
			.append(getAllinpayOrderId())
			.append(getSoid())
			.append(getFileName())
			.append(getApsSequence())
			.append(getWithdrawSequence())
			.append(getReverseSequence())
			.append(getInnerCode())
			.append(getDealResult())
			.append(getCashPay())
			.append(getPackageId())
			.append(getOrderNo())
			.append(getPayerReferrerUrl())
			.append(getCardBin())
			.append(getAuthCode())
			.append(getReturnCode())
			.toHashCode();
	}
	/**
	 * 对象是否一样 .
	 * @return boolean 对象是否一样
	 */
	public boolean equals(Object obj) {
		if(obj instanceof PayOrder == false) return false;
		if(this == obj) return true;
		PayOrder other = (PayOrder)obj;
		return new EqualsBuilder()
			.append(getOrderId(), other.getOrderId())
			.append(getCreateTime(), other.getCreateTime())
			.append(getRequesId(), other.getRequesId())
			.append(getTransTime(), other.getTransTime())
			.append(getTransAmount(), other.getTransAmount())
			.append(getSuccAmount(), other.getSuccAmount())
			.append(getCryType(), other.getCryType())
			.append(getPayType(), other.getPayType())
			.append(getStatus(), other.getStatus())
			.append(getOrderChnl(), other.getOrderChnl())
			.append(getOrderType(), other.getOrderType())
			.append(getTradeMode(), other.getTradeMode())
			.append(getTradeType(), other.getTradeType())
			.append(getOrderFrom(), other.getOrderFrom())
			.append(getPayCustUserId(), other.getPayCustUserId())
			.append(getPayCustName(), other.getPayCustName())
			.append(getPayCustAcct(), other.getPayCustAcct())
			.append(getPayCustCardNo(), other.getPayCustCardNo())
			.append(getColCustUserId(), other.getColCustUserId())
			.append(getColCustName(), other.getColCustName())
			.append(getColCustAcct(), other.getColCustAcct())
			.append(getColCustCardNo(), other.getColCustCardNo())
			.append(getTradeNo(), other.getTradeNo())
			.append(getTardeName(), other.getTardeName())
			.append(getExtOrderNo(), other.getExtOrderNo())
			.append(getFrozenAmount(), other.getFrozenAmount())
			.append(getFrozenTime(), other.getFrozenTime())
			.append(getRefundTime(), other.getRefundTime())
			.append(getRefundAmount(), other.getRefundAmount())
			.append(getRefundTimes(), other.getRefundTimes())
			.append(getComamt(), other.getComamt())
			.append(getOperNo(), other.getOperNo())
			.append(getBackUp(), other.getBackUp())
			.append(getLastUpdateTime(), other.getLastUpdateTime())
			.append(getLastStatus(), other.getLastStatus())
			.append(getIpAddr(), other.getIpAddr())
			.append(getTransPassword(), other.getTransPassword())
			.append(getPayCardIssCode(), other.getPayCardIssCode())
			.append(getPayCardIssDsp(), other.getPayCardIssDsp())
			.append(getColCardIssCode(), other.getColCardIssCode())
			.append(getColCardIssDsp(), other.getColCardIssDsp())
			.append(getPayCardType(), other.getPayCardType())
			.append(getColCardType(), other.getColCardType())
			.append(getCompanyId(), other.getCompanyId())
			.append(getPayCustomerUrl(), other.getPayCustomerUrl())
			.append(getServerUrl(), other.getServerUrl())
			.append(getTermCode(), other.getTermCode())
			.append(getReferenceNo(), other.getReferenceNo())
			.append(getSysTraceNo(), other.getSysTraceNo())
			.append(getAllinpayOrderId(), other.getAllinpayOrderId())
			.append(getSoid(), other.getSoid())
			.append(getFileName(), other.getFileName())
			.append(getApsSequence(), other.getApsSequence())
			.append(getWithdrawSequence(), other.getWithdrawSequence())
			.append(getReverseSequence(), other.getReverseSequence())
			.append(getInnerCode(), other.getInnerCode())
			.append(getDealResult(), other.getDealResult())
			.append(getCashPay(), other.getCashPay())
			.append(getPackageId(), other.getPackageId())
			.append(getOrderNo(), other.getOrderNo())
			.append(getPayerReferrerUrl(), other.getPayerReferrerUrl())
			.append(getCardBin(), other.getCardBin())
			.append(getAuthCode(), other.getAuthCode())
			.append(getReturnCode(), other.getReturnCode())
			.isEquals();
	}
}

