package javacommon.ggpt;

import java.util.Locale;
import java.util.Set;

import javacommon.ggpt.util.AopUtils;
import javacommon.ggpt.util.ErrorMsgUtils;
import javacommon.validator.ValidatorHolder;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.allinpay.util.Md5Utils;
import com.allinpay.util.PropertiesUtils;

/**
 * 开发平台接口基础服务类 (AOP Globebill Open Platform). 主要作用: 其他api需继承该类，返回国际化异常信息
 * 
 * @author wangwch
 */
public abstract class BaseRestService {

	protected static final String TXN_SUCCESS = "0000";
	/**
	 * AOP 系统级参数
	 */
	public static final String APP_KEY = "appKey";
	public static final String FORMAT = "format";
	public static final String METHOD = "method";
	public static final String TIMESTAMP = "timestamp";
	public static final String VERSION = "v";
	public static final String API_SIGN = "api_sign";
	public static final String SIGN_V = "sign_v";

	/**
	 * 错误码定义
	 * */
	public static final String MISS_MUST_PARA = "50";

	/**
	 * 业务级通用参数
	 */
	public static final String ORDER_ID = "order_id";

	// 日志变量
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	ResourceBundleMessageSource messageSource;

	/**
	 * 获取i18n国际化信息
	 * 
	 * @param code
	 * @return 无效传入参数返回
	 */
	protected String getMessage(String code) {
		return messageSource.getMessage(code, null, Locale.SIMPLIFIED_CHINESE);
	}

	/**
	 * 获取i18n国际化信息
	 * 
	 * @param param
	 *            错误码
	 * @param param
	 *            错误信息，如卡号
	 * @return 无效传入参数 param
	 */
	protected String getMessage(String code, String param) {
		String[] params = new String[] { param };
		return messageSource.getMessage(code, params, Locale.SIMPLIFIED_CHINESE);
	}

	/**
	 * 获取i18n国际化信息
	 * 
	 * @param param
	 *            错误码
	 * @param params
	 *            错误信息，多个参数值
	 * @return 无效传入参数 param
	 */
	protected String getMessage(String code, Object[] params) {
		return messageSource.getMessage(code, params, Locale.SIMPLIFIED_CHINESE);
	}

	/**
	 * 获取i18n国际化信息
	 * 
	 * @param errorType
	 *            错误类型
	 * @param param
	 *            错误数据
	 * @return 子业务错误码
	 */
	protected String getSubCode(String errorType, String param) {

		return ErrorMsgUtils.getErrorCodeByErrorType(messageSource, errorType, param);
	}

	/**
	 * 获取i18n国际化信息
	 * 
	 * @param errorType
	 *            错误类型
	 * @param param
	 *            错误数据
	 * @return 子业务错误信息
	 */
	protected String getSubMsg(String errorType, String param) {
		return ErrorMsgUtils.getErrorMsgByErrorType(messageSource, errorType, param);
	}

	/**
	 * aop平台上送交易的合法性校验 1.签名验证 2.ip地址限制
	 * 
	 * @param app_key
	 * @param method
	 * @param v
	 * @param timestamp
	 * @param apiSign
	 * @param 客户交易ip地址
	 *            可为null
	 * @return 异常 Response
	 */
	protected Response aopValidation(String appKey, String method, String v, String timestamp, String apiSign,
			String ip, String format) {

		if (!signValidation(appKey, method, v, timestamp, apiSign)) {

			String code = "52";
			String msg = getMessage(code);
			String subCode = "invalid-permission";
			String subMsg = getMessage(subCode);
			return AopUtils.getBusinessErrorResponse(format, code, msg, subCode, subMsg);
		}

		if (!ipValidation(ip)) {

			String code = "52";
			String msg = getMessage(code);
			String subCode = "invalid-permission";
			String subMsg = getMessage(subCode);
			return AopUtils.getBusinessErrorResponse(format, code, msg, subCode, subMsg);
		}

		return null;
	}

	/**
	 * aop平台上送交易的合法性校验 1.签名验证 2.ip地址限制
	 * 
	 * @param app_key
	 * @param method
	 * @param v
	 * @param timestamp
	 * @param apiSign
	 * @param 客户交易ip地址
	 *            可为null
	 * @return 异常 Response
	 */
	protected Response aopValidation(MultivaluedMap<String, String> formParams, String ip) {

		String appKey = formParams.getFirst(APP_KEY);
		String method = formParams.getFirst(METHOD);
		String v = formParams.getFirst(VERSION);
		String timestamp = formParams.getFirst(TIMESTAMP);
		String apiSign = formParams.getFirst(API_SIGN);
		String format = formParams.getFirst(FORMAT);

		if (!signValidation(appKey, method, v, timestamp, apiSign)) {

			String code = "52";
			String msg = getMessage(code);
			String subCode = "invalid-permission";
			String subMsg = getMessage(subCode);
			return AopUtils.getBusinessErrorResponse(format, code, msg, subCode, subMsg);
		}

		if (!ipValidation(ip)) {

			String code = "52";
			String msg = getMessage(code);
			String subCode = "invalid-permission";
			String subMsg = getMessage(subCode);
			return AopUtils.getBusinessErrorResponse(format, code, msg, subCode, subMsg);
		}

		return null;
	}

	/**
	 * aop平台上送交易的合法性校验 1.签名验证 2.ip地址限制
	 * 
	 * @param MultivaluedMap
	 *            <String, String>
	 * @return 异常 Response
	 */
	protected Response aopValidation(MultivaluedMap<String, String> formParams) {

		return aopValidation(formParams, null);
	}

	/**
	 * aop平台上送交易的合法性校验 1.签名验证 2.ip地址限制
	 * 
	 * @param app_key
	 * @param method
	 * @param v
	 * @param timestamp
	 * @param apiSign
	 * @return 异常 Response
	 */
	protected Response aopValidation(String appKey, String method, String v, String timestamp, String apiSign,
			String format) {
		return aopValidation(appKey, method, v, timestamp, apiSign, null, format);
	}

	/**
	 * 参数校验
	 * 
	 * @param param
	 *            需要做校验的request对象
	 * @param subcode
	 *            request校验失败对应的subcode码
	 * @param fmt
	 *            response格式
	 * @return 业务错误response对象或者null(成功的情况)
	 * @modified 2012-6-13 :: 上午10:07:46
	 */
	protected <T> Response paramValidation(T req, String subCode, String fmt) {
		// 校验参数
		Set<ConstraintViolation<T>> sets = ValidatorHolder.validate(req);
		if (sets.size() > 0) {
			for (ConstraintViolation<T> v : sets) {
				String code = "51";
				String msg = getMessage(code);
				String submsg = getMessage(subCode, v.getMessage());
				return AopUtils.getBusinessErrorResponse(fmt, code, msg, subCode, submsg);
			}
		}
		return null;
	}

	/**
	 * 根据appKey 取得 所属机构号，且o_app和o_partners 的状态必须正常
	 * 
	 * @param appKey
	 * @return Partners orgId
	 */
	protected String getPartnersBrhId(String appKey) {
		String key = "PartnersBrhId_" + appKey;
		String partnersBrhId = PropertiesUtils.getGlobalProperties(key);
		return partnersBrhId;
	}

	/**
	 * 验证AOP平台上送的验签串是否正确
	 */
	private boolean signValidation(String appKey, String method, String v, String timestamp, String apiSign) {
		String signKey = getApiSign(method, v);
		String sign = Md5Utils.signature(signKey + appKey + method + v + timestamp + signKey);
		if (sign.toUpperCase().equals(apiSign.toUpperCase())) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 验证ip是否属于合法的地址 暂不使用，全部返回成功
	 * 
	 * @param ip
	 * @return
	 */
	private boolean ipValidation(String ip) {
		return true;
	}

	/**
	 * 根据api method 获取接口的验签串
	 * 
	 * @param method
	 * @param v
	 * @return api sign
	 */
	private String getApiSign(String method, String v) {
		String key = "ApiSign_" + method + "_" + v;
		return PropertiesUtils.getGlobalProperties(key);
	}

}
