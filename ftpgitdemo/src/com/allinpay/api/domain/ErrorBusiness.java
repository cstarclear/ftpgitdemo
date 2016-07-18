package com.allinpay.api.domain;

import javacommon.ggpt.AopObject;

/**
 * 错误应答码及对应的中文信息
 * @author wangwch
 *
 */
public class ErrorBusiness extends AopObject {

	private static final long serialVersionUID = 1594993986514807071L;

	/**
	 * 交易码.
	 */
	private String code;
	/**
	 * 交易描述.
	 */
	private String msg;
	/**
	 * 子交易码.
	 */
	private String subCode;
	/**
	 * 子交易码描述.
	 */
	private String subMsg;

	public ErrorBusiness() {
		super();
	}

	public ErrorBusiness(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ErrorBusiness(String code, String msg, String subCode, String subMsg) {
		super();
		this.code = code;
		this.msg = msg;
		this.subCode = subCode;
		this.subMsg = subMsg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getSubMsg() {
		return subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

}
