package javacommon.ggpt.util;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 钱宝开放平台异常信息工具类.
 * @author wangch
 * @since 1.0  2011-01-08
 *
 */
public class ErrorMsgUtils {

	/** 缺少参数*/
	public static final String MISSING_PARAMETER = "missing-parameter";
	/**参数无效，格式不对、非法值、越界等*/
	public static final String INVALID_PARAMETER = "invalid-paramete";
	/**业务逻辑错误 */
	public static final String BUSINESS_ERROR = "business-error";
	/**权限不够、非法访问*/
	public static final String INVALID_PERMISSION = "invalid-permission";
	/**根据输入信息查不到相应的信息*/
	public static final String NOT_EXIST = "not-exist";

	/** 缺少参数的父级code 50 */
	public static final String MISSING_PARAMETER_CODE = "50";
	/**参数无效，格式不对、非法值、越界等的父级code 51*/
	public static final String INVALID_PARAMETER_CODE = "51";
	/**业务逻辑错误 的父级code 53*/
	public static final String BUSINESS_ERROR_CODE = "53";
	/** 卡号不存在 */
	public static final String CARD_NOT_EXIST = "10001";
	/** 卡号非本机构发行 */
	public static final String CARD_NOT_BELONG_BRH = "10002";
	/** 交易处理失败 */
	public static final String TRANS_ERROR = "99999";
	/**
	 * 根据错误类型和自定义错误信息返回subCode
	 * @param messageSource
	 * @param errorType
	 * @param param
	 * @return subCode   如 missing-parameter:card_id  
	 */
	public static String getErrorCodeByErrorType(ResourceBundleMessageSource messageSource, String errorType,
			String param) {
		String[] params = new String[] { param };
		return messageSource.getMessage(errorType + "-code", params, Locale.SIMPLIFIED_CHINESE);
	}

	/**
	 * 根据错误类型和自定义错误信息返回subMsg
	 * @param messageSource
	 * @param errorType
	 * @param param
	 * @return subMsg   如 缺少必要的参数:卡号
	 */
	public static String getErrorMsgByErrorType(ResourceBundleMessageSource messageSource, String errorType,
			String param) {
		String[] params = new String[] { param };
		return messageSource.getMessage(errorType + "-msg", params, Locale.SIMPLIFIED_CHINESE);
	}

}
