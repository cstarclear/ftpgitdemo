package javacommon.ggpt.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javacommon.ggpt.ApiException;
import javacommon.ggpt.RsConstants;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.funee.framework.util.ApplicationContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.allinpay.api.domain.ErrorBusiness;
import com.allinpay.api.response.ErrorBusinessResponse;
import com.allinpay.util.CryptoUtils;
import com.allinpay.util.DozerHolder;

/**
 * AOP(钱宝开放平台工具类). REST 服务
 * 
 * @author wangch
 * @since 1.0 2011-01-08
 * 
 */
public class AopUtils {

	/**
	 * resource bundle holder
	 */
	private static class MsgHoler {
		static ResourceBundleMessageSource bundle = (ResourceBundleMessageSource) ApplicationContextHolder
				.getBean("messageSource");

		static String getMessage(String code) {
			return bundle.getMessage(code, null, Locale.SIMPLIFIED_CHINESE);
		}
	}

	/**
	 * 获取设定格式的传输数据
	 * 
	 * @param format
	 *            格式化类型，分xml或json
	 * @param dto
	 *            数据传输对象(DTO)
	 * @return Response
	 */
	public static Response getFormatResponse(String format, Object dto) {
		if (AopAssert.isEmpty(format)) {
			format = RsConstants.FORMAT_XML;
		}
		format = format.toLowerCase();
		// 返回XML格式的对象.
		if (RsConstants.FORMAT_XML.equals(format)) {
			return Response.ok(dto, MediaType.APPLICATION_XML + RsConstants.CHARSET_XML).build();
		} else {
			// 返回JSON格式的对象.
			return Response.ok(dto, MediaType.APPLICATION_JSON).build();
		}
	}

	/**
	 * 返回业务Apo定义的错误信息
	 * 
	 * @param format
	 *            格式 xml 或者json
	 * @param code
	 *            业务父错误码
	 * @param msg
	 *            业务父错误信息
	 * @param subCode
	 *            业务子错误码
	 * @param subMsg
	 *            业务子错误信息
	 * @return BusinessErrorResponse
	 */
	public static Response getBusinessErrorResponse(String format, String code, String msg, String subCode,
			String subMsg) {
		ErrorBusinessResponse businessErrorResponse = new ErrorBusinessResponse(code, msg, subCode, subMsg);
		return getFormatResponse(format, businessErrorResponse);
	}

	/**
	 * 返回业务Apo定义的错误信息
	 * 
	 * @param format
	 *            格式 xml 或者json
	 * @param code
	 *            业务父错误码
	 * @param subCode
	 *            业务子错误码
	 * @return BusinessErrorResponse
	 */
	public static Response getBusinessErrorResponse(String format, String code, String subCode) {
		ErrorBusinessResponse businessErrorResponse = new ErrorBusinessResponse(code, MsgHoler.getMessage(code),
				subCode, MsgHoler.getMessage(subCode));
		return getFormatResponse(format, businessErrorResponse);
	}

	/**
	 * 获取业务级参数,组织成HashMap
	 * 
	 * @param formParams
	 */
	public static Map<String, String> getBusinessParametersHashMap(MultivaluedMap<String, String> formParams) {
		formParams.remove(RsConstants.APP_KEY);
		formParams.remove(RsConstants.FORMAT);
		formParams.remove(RsConstants.METHOD);
		formParams.remove(RsConstants.TIMESTAMP);
		formParams.remove(RsConstants.VERSION);
		formParams.remove(RsConstants.API_SIGN);

		Map<String, String> parametersHashMap = new HashMap<String, String>();
		for (String key : formParams.keySet()) {
			parametersHashMap.put(StringHelper.trans(key), formParams.getFirst(key));
		}
		return parametersHashMap;
	}

	/**
	 * 获取业务级请求对象,组织成***Request
	 * 
	 * @param formParams
	 *            MultivaluedMap<String, String>
	 * @return T ***Request
	 */
	public static <T> T getBusinessRequest(MultivaluedMap<String, String> formParams, Class<T> destinationClass) {

		Map<String, String> parametersHashMap = getBusinessParametersHashMap(formParams);

		return DozerHolder.map(parametersHashMap, destinationClass);

	}

	/**
	 * 转换校验的错误数据
	 * 
	 * @param constraintViolations
	 * @return ErrorBusiness
	 */
	public static ErrorBusiness convertMessage(Set<? extends ConstraintViolation> constraintViolations) {

		String violationCode = "";
		String violationMessage = "";

		for (ConstraintViolation violation : constraintViolations) {
			String propertyPath = violation.getPropertyPath().toString();
			if (violationCode.indexOf(propertyPath) == -1) {
				violationCode = violationCode + "^" + propertyPath;
			}
			violationMessage = violationMessage + "^" + propertyPath + "=" + violation.getMessage();
		}

		String code = ErrorMsgUtils.INVALID_PARAMETER_CODE;

		return new ErrorBusiness(code, code, violationCode, violationMessage);

	}

	/**
	 * 获取O_SIAN_SECRET的app_key ,signV对应的数据 data_secret，用于关键数据的加解密
	 * 
	 * @param appKey
	 * @param signV
	 * @return dataSecret
	 */
	// public static String getDataSecret(String appKey, String signV) {
	// OsignSecretManager osignSecretManager = (OsignSecretManager)
	// ApplicationContextHolder
	// .getBean("osignSecretManager");
	// return osignSecretManager.getDataSecret(appKey, signV);
	// }

	/**
	 * 获取关键数据的原值
	 * 
	 * @param encryptKeyData
	 * @param appKey
	 * @param signV
	 *            签名版本号
	 * @param timestamp
	 * @return keyData 原始值为空,返回为空,否则取原始值
	 * @throws ApiException
	 */
	// public static String getKeyData(String encryptKeyData, String appKey,
	// String signV, String timestamp)
	// throws ApiException {
	// if (encryptKeyData == null) {
	// return null;
	// }
	// String dataSecret = getDataSecret(appKey, signV);
	// String keyData = null;
	// try {
	// keyData = CryptoUtils.desDecryptFromBase64(encryptKeyData,
	// dataSecret.getBytes());
	// } catch (Exception e) {
	// throw new ApiException("加密数据验证不合法");
	// }
	// if (!keyData.startsWith(timestamp + "aop")) {
	// throw new ApiException("加密数据验证不合法");
	// }
	// //返回原始数据,去除固定的 时间戳+aop,共17位
	// keyData = keyData.substring(17, keyData.length());
	//
	// return keyData;
	// }

	/**
	 * 获取关键数据的原值
	 * 
	 * @param encryptKeyData
	 * @param appKey
	 * @param timestamp
	 * @return keyData 原始值为空,返回为空,否则取原始值
	 * @throws ApiException
	 */
	public static String getKeyDataBySecret(String encryptKeyData, String dataSecret, String timestamp)
			throws ApiException {
		if (encryptKeyData == null) {
			return null;
		}

		String keyData = null;
		try {
			keyData = CryptoUtils.desDecryptFromBase64(encryptKeyData, dataSecret.getBytes());
		} catch (Exception e) {
			throw new ApiException("加密数据验证不合法");
		}
		if (!keyData.startsWith(timestamp + "aop")) {
			throw new ApiException("加密数据验证不合法");
		}
		// 返回原始数据,去除固定的 时间戳+aop,共17位
		keyData = keyData.substring(17, keyData.length());

		return keyData;
	}

}
