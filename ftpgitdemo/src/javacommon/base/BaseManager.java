package javacommon.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基本的业务流程逻辑的抽象类,实现业务流程的控制;
 * 实现了基于表的CRUD
 * @author wfun
 */
public abstract class BaseManager{
	//日志变量
	protected Logger logger = LoggerFactory.getLogger(getClass());
}
