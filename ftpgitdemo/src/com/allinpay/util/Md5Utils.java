package com.allinpay.util;

import java.security.MessageDigest;

/**
 * md5 加密工具类
 * @author wangwch
 *
 */
public class Md5Utils {

	/**
	 * 生成有效签名
	 * 
	 * @param params
	 * @param secret
	 * @return
	 */
	public static String signature(String orgin) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
		} catch (Exception e) {
			throw new java.lang.RuntimeException("sign error !");
		}
		return result;
	}

	/**
	 * 二行制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString().toLowerCase();
	}
}
