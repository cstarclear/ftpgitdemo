package com.allinpay.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 对象转换工具类.
 * 封装Dozer, 转换对象类型.
 * 用于持有Spring Dozer,使调用Dozer可以当静态方法使用.
 * 
 * <pre>
 * static 方法调用:
 * DozerHolder.map(Object source, Class<T> destinationClass);
 * </pre>
 * <pre>
 * </pre> 
 * @author wangwch
 *
 */
public class DozerHolder implements DisposableBean {
	/**
	 * 对象数据转换工具类
	 */
	private static DozerBeanMapper dozer;

	public static DozerBeanMapper getDozer() {
		assertDozerInjected();
		return dozer;
	}
	@Autowired
	public void setDozer(DozerBeanMapper dozer) {

		DozerHolder.dozer = dozer;
	}

	/**
	 * 基于Dozer转换对象的类型
	 * @param <T>
	 * @param source
	 * @param destinationClass
	 * @return
	 */
	public static <T> T map(Object source, Class<T> destinationClass) {
		return getDozer().map(source, destinationClass);
	}

	/**
	 *基于Dozer转换List中对象的类型. 
	 * @param <T>
	 * @param sourceList
	 * @param destinationClass
	 * @return
	 */
	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
		List<T> destinationList = new ArrayList<T>();
		for (Object sourceObject : sourceList) {
			T destinationObject = getDozer().map(sourceObject, destinationClass);
			destinationList.add(destinationObject);
		}
		return destinationList;
	}

	@Override
	public void destroy() throws Exception {
		DozerHolder.clearHolder();

	}

	private static void assertDozerInjected() {

		if (dozer == null) {
			throw new IllegalStateException("dozer属性未注入.");
		}
	}

	/**
	 * 清除Holder中的validator为null.
	 */
	public static void clearHolder() {
		dozer = null;
	}

}
