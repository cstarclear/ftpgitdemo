package com.allinpay.api.response;

import javacommon.ggpt.AopObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 错误应答码及对应的中文信息
 * @author wangwch
 *
 */
@XmlRootElement(name = "error_business_response")
public class ErrorBusinessResponse extends AopObject {

	private static final long serialVersionUID = -6280830485319396250L;

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

	public ErrorBusinessResponse() {
		super();
	}

	public ErrorBusinessResponse(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ErrorBusinessResponse(String code, String msg, String subCode, String subMsg) {
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

	@XmlElement(name = "sub_code")
	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	@XmlElement(name = "sub_msg")
	public String getSubMsg() {
		return subMsg;
	}

	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}

}
