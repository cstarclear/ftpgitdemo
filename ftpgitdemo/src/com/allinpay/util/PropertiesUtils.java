package com.allinpay.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * Properties 工具类
 * 
 * @author wangwch
 * @date 2006-8-27
 * @version 1.0
 */
public class PropertiesUtils {

	private static Properties globalProperties = GetPropertiesByClassPath("global.properties");
	private static Properties companyMappings = GetPropertiesByClassPath("company-map.properties");

	/**
	 * 根据传入的comId，和aliases判断，是否有alias对应的comId和传入的comId匹配，若存在，返回true 否则false
	 * 
	 * @modified 2012-7-24 :: 下午12:47:24
	 */
	public static boolean match(String comId, String... aliases) {
		if (aliases.length == 0 || StringUtils.isEmpty(comId))
			return false;
		for (String alias : aliases) {
			if (comId.equals(loadComId(alias))) {
				return true;
			}
		}
		return false;
	}

	public static String loadComId(String alias) {
		if (alias == null)
			return "";
		return companyMappings.getProperty(alias);
	}

	/**
	 * 从classPath 取得Properties配置文件信息
	 * 
	 * @param path
	 * @return
	 */
	public static Properties GetPropertiesByClassPath(String path) {

		Resource resource = new ClassPathResource(path);
		Properties roperties = null;
		try {
			roperties = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return roperties;

	}

	/**
	 * 根据Global.Properties 定义的key，得到对应的value值
	 * 
	 * @param key
	 * @return value
	 */
	public static String getGlobalProperties(String key) {
		String value = globalProperties.getProperty(key);

		if (value == null) {
			value = "";
		}
		return value;
	}

}
