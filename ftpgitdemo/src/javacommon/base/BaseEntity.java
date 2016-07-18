package javacommon.base;

//静态导入日期转换方法
import org.funee.framework.util.DateConvertUtils;

/**
 * 基本的modle类，可继承，且被序列化
 * @author wfun
 */
public class BaseEntity implements java.io.Serializable {
	//日期格式
	protected static final String DATE_FORMAT = "yyyy-MM-dd";
	//时间格式
	protected static final String TIME_FORMAT = "HH:mm:ss";
	//日期时间格式
	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	//日期时间格式
	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

	//日期时间转字符串
	public static String date2String(java.util.Date date, String dateFormat) {
		return DateConvertUtils.format(date, dateFormat);
	}

	//字符串转日期时间
	public static <T extends java.util.Date> T string2Date(String dateString, String dateFormat,
			Class<T> targetResultType) {
		return DateConvertUtils.parse(dateString, dateFormat, targetResultType);
	}
}
