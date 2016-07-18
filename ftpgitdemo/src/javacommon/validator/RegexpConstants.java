package javacommon.validator;

/**
 * Validator ,正则表达式工具类
 *   
 * @author wangwch
 * @since 1.0 2011-01-18
 */
public class RegexpConstants {

	/**
	 * 验证邮箱
	 * @param 待验证的字符串
	 * @return 如果是符合的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String EMAIL = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

	private static final String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
	/**
	 * 验证IP地址
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String IP = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";

	/**
	 * 验证网址Url
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

	/**
	 * 验证电话号码
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String TELEPHONE = "^(\\d{3,4}-)?\\d{6,8}$";

	/**
	 * 验证输入密码条件(字符与数据同时出现)
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String PASSWORD = "[A-Za-z]+[0-9]";

	/**
	 * 验证输入密码长度 (6-18位)
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String PASSWORD_LENGTH = "^\\d{6,18}$";

	/**
	 * 验证输入邮政编号
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String POSTAL_CODE = "^\\d{6}$";
	/**
	 * 验证输入手机号码
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String HANDSET = "^[1]+[3,4,5,7,8]+\\d{9}$";

	/**
	 * 验证输入一年的12个月
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String MONTH = "^(0?[1-9]|1[0-2])$";

	/**
	 * 验证输入一个月的31天
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String DAY = "^((0?[1-9])|((1|2)[0-9])|30|31)$";

	/**
	 * 验证日期时间,短时间，形如  YYYY-MM-DD(2011-01-01)
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String DATE = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))$";

	/**
	 * 验证日期时间,短时间，形如  YYYYMMDD(20110101)
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String DATE_YYYYMMDD = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))$";

	/**
	 * 验证日期时间,长时间，形如 YYYY-MM-DD hh:mm:ss (2011-01-01 01:01:01)
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String DATE_TIME = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";

	/**
	 * 验证日期时间,长时间，形如  YYYYMMDDhhmmss (20110101010101)
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String DATETIME_YYYYMMDDHHMMSS = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))(20|21|22|23|[0-1]?\\d)[0-5]?\\d[0-5]?\\d$";

	/**
	 * 验证日期时间,长时间，形如hh:mm:ss (01:01:01)
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String TIME = "^(20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";

	/**
	 * 验证日期时间,长时间，形如  hhmmss (010101)
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String TIME_HHMMSS = "^(20|21|22|23|[0-1]?\\d)[0-5]?\\d[0-5]?\\d$";

	/**
	 * 验证纯数字输入
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String NUMBER = "^[0-9]*$";

	/**
	 * 验证数字输入,可包括整数或小数
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String DECIMAL = "^[+-]?[0-9]+(\\.[0-9]*)?$";

	/**
	 * 验证非零的正整数
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String INT_NUMBER = "^\\+?[1-9][0-9]*$";

	/**
	 * 验证大写字母
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String UP_CHAR = "^[A-Z]+$";

	/**
	 * 验证小写字母
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String LOW_CHAR = "^[a-z]+$";

	/**
	 * 验证验证输入字母
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String LETTER = "^[A-Za-z]+$";

	/**
	 * 验证验证输入汉字
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String CHINESE = "^[\u4e00-\u9fa5],{0,}$";

	/**
	 * 验证验证输入字符串
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String LENGTH = "^.{8,}$";

	/**
	 * 金额验证，必须带两位小数的金额  格式 15.00
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String MONEY = "^[0-9]+(.[0-9]{2})?$";
	
	/**
	 * 手机号13+9位数字
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static final String MOBILE_PHONE = "^1[3|4|5|8|9][0-9]{9}$";

}
