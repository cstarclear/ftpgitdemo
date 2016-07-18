package javacommon.ggpt;

/**
 * REST 常量定义.
 * 
 * @author wangwch
 * @since 1.0 2011-01-08
 */
public class RsConstants {

	/**项目内统一的XML charset定义, for REST*/
	public static final String CHARSET_XML = ";charset=UTF-8";

	/** 默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** UTF-8字符集 **/
	public static final String CHARSET_UTF8 = "UTF-8";

	/** GBK字符集 **/
	public static final String CHARSET_GBK = "GBK";

	/** AOP JSON 应格式 */
	public static final String FORMAT_JSON = "json";
	/** AOP XML 应格式 */
	public static final String FORMAT_XML = "xml";
	
	/** MD5签名方式 */
	public static final String SIGN_METHOD_MD5 = "md5";
	/** HMAC签名方式 */
	public static final String SIGN_METHOD_HMAC = "hmac";
	/** HMAC签名方式 */
	public static final String SIGN_METHOD_DSA = "dsa";

	/**
	 * AOP 系统级参数
	 */
	public static final String APP_KEY = "appKey";
	public static final String FORMAT = "format";
	public static final String METHOD = "method";
	public static final String TIMESTAMP = "timestamp";
	public static final String VERSION = "v";
	public static final String SIGN = "sign";
	public static final String SIGN_V = "sign_v";
	public static final String PARTNER_ID = "partner_id";
	public static final String SESSION = "session";
	public static final String API_SIGN = "api_sign";
	
	/**
	 * VERSION 可用版本定义,1.0,2.0,3.0 等等
	 */
	public static final String OPENVERSION = "open_version";
	
	public static final String VERSION_1 = "1";

}
