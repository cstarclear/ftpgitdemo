package javacommon.ggpt;

import java.io.Serializable;

/**
 * 数据传输对象基本类，其他DTO对象继承
 * 
 * @author wangwch
 * @since 1.0, 2011-01-17
 */
public abstract class AopObject implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 用于数组或者List的定义  @XmlElementWrapper(name = "card"+ARRAYS_SUFFIX) */
	public static final String ARRAYS_SUFFIX = "_arrays";

}
