package javacommon.ggpt.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 方法入参检测工具类 代码示例:
 * 
 * <pre class="code">
 * AopAssert.isNull(uName);
 * </pre>
 * 
 * @author wangwch
 * @since 1.0 2011-01-18
 */
public class AopAssert {
	/**
	 * 验证对象是否为null
	 * 
	 * @param object
	 * @return 如果对象为null，返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isNull(Object object) {
		if (object == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 验证字符串是否为空
	 * 
	 * @param object
	 * @return 如果对象为null，返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isEmpty(String value) {
		if (value == null || value.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 正则表达式验证数据
	 * 
	 * @param regexString
	 *            正则字符串
	 * @param validateString
	 *            验证字符串
	 * @return 如果validateString 符合 regex的正则表达式格式,返回 <b>true </b>,否则为 <b>false
	 *         </b>
	 */
	public static boolean patternValidator(String regex, String validateString) {
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(validateString);
		return m.matches();
	}

	/**
	 * 正则表达式验证数据
	 * 
	 * @param regexString
	 *            正则字符串
	 * @param validateString
	 *            验证字符串
	 * @return 如果validateString 符合 regex的正则表达式格式,返回 <b>true </b>,否则为 <b>false
	 *         </b>
	 */
	public static boolean patternValidator(String regex, int flags, String validateString) {
		Pattern pattern = Pattern.compile(regex, flags);
		Matcher m = pattern.matcher(validateString);
		return m.matches();
	}

	/**
	 * 验证邮箱
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isEmail(String validateString) {
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		return patternValidator(regex, Pattern.CASE_INSENSITIVE, validateString);
	}

	/**
	 * 验证IP地址
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isIP(String validateString) {
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证网址Url
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isUrl(String validateString) {
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证电话号码
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isTelephone(String validateString) {
		String regex = "^(\\d{3,4}-)?\\d{6,8}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证输入密码条件(字符与数据同时出现)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isPassword(String validateString) {
		String regex = "[A-Za-z]+[0-9]";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证输入密码长度 (6-18位)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isPasswLength(String validateString) {
		String regex = "^\\d{6,18}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证输入密码条件,是否为数字6位
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isCardPassword(String validateString) {
		String regex = "^\\d{6}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证输入邮政编号
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isPostalcode(String validateString) {
		String regex = "^\\d{6}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证输入手机号码
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isHandset(String validateString) {
		String regex = "^[1]+[3,5,8]+\\d{9}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 身份证号码验证
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isIDcard(String validateString) {
		String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2" };
		String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5",
				"8", "4", "2" };
		String areaCode = "11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91";

		String Ai = "";
		if (validateString.length() != 15 && validateString.length() != 18) {
			return false;
		}

		if (validateString.length() == 18) {
			Ai = validateString.substring(0, 17);
		} else if (validateString.length() == 15) {
			Ai = validateString.substring(0, 6) + "19" + validateString.substring(6, 15);
		}

		if (isNumber(Ai) == false) {
			return false;
		}

		String strYear = Ai.substring(6, 10);// 年份
		String strMonth = Ai.substring(10, 12);// 月份
		String strDay = Ai.substring(12, 14);// 月份
		if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
			return false;
		}

		if (areaCode.indexOf(Ai.substring(0, 2)) == -1) {
			return false;
		}

		// ================ 判断最后一位的值 ================
		int TotalmulAiWi = 0;
		for (int i = 0; i < 17; i++) {
			TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i)))
					* Integer.parseInt(Wi[i]);
		}
		int modValue = TotalmulAiWi % 11;
		String strVerifyCode = ValCodeArr[modValue];
		Ai = Ai + strVerifyCode;

		if (validateString.length() == 18) {
			if (Ai.equals(validateString.toLowerCase()) == false) {
				return false;
			}
		}

		// =====================(end)=====================
		return true;
	}

	/**
	 * 验证输入一年的12个月
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isMonth(String validateString) {
		String regex = "^(0?[1-9]|1[0-2])$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证输入一个月的31天
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDay(String validateString) {
		String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证日期时间,短时间，形如 YYYY-MM-DD(2011-01-01)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDate(String validateString) {
		String regex = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证日期时间,短时间，形如 YYYYMMDD(20110101)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDateYYYYMMDD(String validateString) {
		String regex = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证日期时间,长时间，形如 YYYY-MM-DD hh:mm:ss (2011-01-01 01:01:01)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDateTime(String validateString) {
		String regex = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证日期是否为yyyyMM形式 必须在200001之后210001之前
	 * 
	 * @modified 2012-9-20 :: 下午01:24:42
	 */
	public static boolean isYearMonth(String validateString) {
		String regex = "^20\\d{2}(1[0-2]|0[1-9])$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证日期时间,长时间，形如 YYYYMMDDhhmmss (20110101010101)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDateTimeYYYYMMDDhhmmss(String validateString) {
		if (isEmpty(validateString) || validateString.length() != 14) {
			return false;
		}
		String regex = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))(20|21|22|23|[0-1]?\\d)[0-5]?\\d[0-5]?\\d$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证日期时间,长时间，形如hh:mm:ss (01:01:01)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isTime(String validateString) {
		String regex = "^(20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证日期时间,长时间，形如 hhmmss (010101)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isTimehhmmss(String validateString) {
		String regex = "^(20|21|22|23|[0-1]?\\d)[0-5]?\\d[0-5]?\\d$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证纯数字输入
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isNumber(String validateString) {
		String regex = "^[0-9]*$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证数字输入,可包括整数或小数
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDecimal(String validateString) {
		String regex = "^[+-]?[0-9]+(\\.[0-9]*)?$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证非零的正整数
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isIntNumber(String validateString) {
		String regex = "^\\+?[1-9][0-9]*$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证大写字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isUpChar(String validateString) {
		String regex = "^[A-Z]+$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证小写字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isLowChar(String validateString) {
		String regex = "^[a-z]+$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证验证输入字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isLetter(String validateString) {
		String regex = "^[A-Za-z]+$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证验证输入汉字
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isChinese(String validateString) {
		String regex = "^[\u4e00-\u9fa5],{0,}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证验证输入字符串
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isLength(String validateString) {
		String regex = "^.{8,}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 验证输入字符串长度是否正确
	 * 
	 * @modified 2012-9-20 :: 下午12:14:48
	 */
	public static boolean isLength(String validateString, int length) {
		String regex = "^.{" + length + "}$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 金额验证，必须带两位小数的金额 格式 15.00
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isMoney(String validateString) {
		String regex = "^[0-9]+(.[0-9]{2})?$";
		return patternValidator(regex, validateString);
	}

	/**
	 * 数字大小验证,小于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果是符合格式的数字小于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean decimalLessThan(String validateString, BigDecimal value) {
		// 如果不是为数字，默认为false
		if (!isDecimal(validateString)) {
			return false;
		}
		BigDecimal validateBigDecimal = new BigDecimal(validateString);
		if (validateBigDecimal.compareTo(value) == -1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 数字大小验证,小于等于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果是符合格式的数字小于或等于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean decimalLessThanEqual(String validateString, BigDecimal value) {
		// 如果不是为数字，默认为false
		if (!isDecimal(validateString)) {
			return false;
		}
		BigDecimal validateBigDecimal = new BigDecimal(validateString);
		if (validateBigDecimal.compareTo(value) == -1 || validateBigDecimal.compareTo(value) == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 数字大小验证,大于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果是符合格式的数字大于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean decimalGreaterThan(String validateString, BigDecimal value) {
		// 如果不是为数字，默认为false
		if (!isDecimal(validateString)) {
			return false;
		}
		BigDecimal validateBigDecimal = new BigDecimal(validateString);
		if (validateBigDecimal.compareTo(value) == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 数字大小验证,大于等于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果是符合格式的数字大于或等于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean decimalGreaterThanEqual(String validateString, BigDecimal value) {
		// 如果不是为数字，默认为false
		if (!isDecimal(validateString)) {
			return false;
		}
		BigDecimal validateBigDecimal = new BigDecimal(validateString);
		if (validateBigDecimal.compareTo(value) == 1 || validateBigDecimal.compareTo(value) == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 数字大小验证,在两个值之间
	 * 
	 * @param validateString
	 * @param minValue
	 *            最小值
	 * @return 如果是符合格式的数字小于等于最大值，大于等于最小值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean decimalRange(String validateString, BigDecimal minValue,
			BigDecimal maxValue) {
		// 如果不是为数字，默认为false
		if (!isDecimal(validateString)) {
			return false;
		}
		BigDecimal validateBigDecimal = new BigDecimal(validateString);
		if (validateBigDecimal.compareTo(minValue) == 1
				&& validateBigDecimal.compareTo(maxValue) == -1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 数字大小验证,在两个值之间
	 * 
	 * @param long validateLong
	 * @param minValue
	 *            最小值
	 * @return 如果是符合格式的数字小于等于最大值，大于等于最小值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean decimalRange(long validateLong, BigDecimal minValue, BigDecimal maxValue) {
		BigDecimal validateBigDecimal = new BigDecimal(validateLong);
		if (validateBigDecimal.compareTo(minValue) == 1
				&& validateBigDecimal.compareTo(maxValue) == -1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 字符串长度大小验证,小于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果字符串长度大小验证,小于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean lengthLessThan(String validateString, int value) {
		// 如果为空，默认返回false
		if (isNull(validateString)) {
			return false;
		}

		if (validateString.length() < value) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 字符串长度大小验证,小于等于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果字符串长度大小验证,小于等于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean lengthLessThanEqual(String validateString, int value) {
		// 如果为空，默认返回false
		if (isNull(validateString)) {
			return false;
		}

		if (validateString.length() <= value) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 字符串长度大小验证,大于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果字符串长度大小验证,大于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean lengthGreaterThan(String validateString, int value) {
		// 如果为空，默认返回false
		if (isNull(validateString)) {
			return false;
		}

		if (validateString.length() > value) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 字符串长度大小验证,大于等于某值
	 * 
	 * @param validateString
	 * @param value
	 *            设定值
	 * @return 如果字符串长度大小验证,大于等于某值,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean lengthGreaterThanEqual(String validateString, int value) {
		// 如果为空，默认返回false
		if (isNull(validateString)) {
			return false;
		}

		if (validateString.length() >= value) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 字符串长度大小验证,在两个值之间
	 * 
	 * @param validateString
	 * @param minValue
	 *            最小值
	 * @return 如果字符串长度大小验证,在设定值之间,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean lengthRange(String validateString, int minValue, int maxValue) {
		// 如果为空，默认返回false
		if (isNull(validateString)) {
			return false;
		}

		if (validateString.length() >= minValue && validateString.length() <= maxValue) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String args[]) {
		System.out.println(isYearMonth("201209"));
		System.out.println(isYearMonth("211101"));
		System.out.println("mail = " + isEmail("www.aaaa.111111111@21.cn"));
		System.out.println("isIP = " + isIP("10.0.1.0"));
		System.out.println("IsUrl = " + isUrl("http://www.sohu.com"));
		System.out.println("IsTelephone = " + isTelephone("021-61680955"));
		System.out.println("IsPassword = " + isPassword("A1"));
		System.out.println("isPasswLength = " + isPasswLength("s11111111"));
		System.out.println("isPostalcode = " + isPostalcode("111222"));
		System.out.println("isHandset = " + isHandset("18621186662"));
		System.out.println("isIDcard = " + isIDcard("33072419830423241X"));
		System.out.println("isDecimal = " + isDecimal("+0111.36"));
		System.out.println("isMonth = " + isMonth("s12"));
		System.out.println("isDay = " + isDay("32"));
		System.out.println("isDate = " + isDate("2012-02-29"));
		System.out.println("isDateTime = " + isDateTime("2012-02-29 23:59:59"));
		System.out.println("isDateYYYYMMDD = " + isDateYYYYMMDD("29120129"));
		System.out.println("isDateTimeYYYYMMDDhhmmss = "
				+ isDateTimeYYYYMMDDhhmmss("20120229235959"));
		System.out.println("isTime = " + isTime("24:59:59"));
		System.out.println("isTimehhmmss = " + isTimehhmmss("235959"));
		System.out.println("isNumber = " + isNumber("0.235959"));
		System.out.println("isIntNumber = " + isIntNumber("1213123123213311313"));
		System.out.println("isUpChar = " + isUpChar("AAAs"));
		System.out.println("isLowChar = " + isLowChar("aaa"));
		System.out.println("isLetter = " + isLetter("asssA"));
		System.out.println("isChinese = " + isChinese("a"));
		System.out.println("isMoney = " + isMoney("111.11"));
		System.out.println("decimalLessThan = "
				+ decimalLessThan("-1111111.5", new BigDecimal(-1111111.5)));
		System.out.println("decimalLessThanEqual = "
				+ decimalLessThanEqual("-1111111.4", new BigDecimal(-1111111.5)));
	}

}
