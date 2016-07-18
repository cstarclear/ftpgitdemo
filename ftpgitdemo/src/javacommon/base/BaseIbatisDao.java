package javacommon.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 基础的CRUD的持久层,用于 ibatis
 * 
 * @author wfun
 * @version 1.0
 */
public abstract class BaseIbatisDao extends SqlMapClientDaoSupport {
	//日志变量
	protected Logger logger = LoggerFactory.getLogger(getClass());
}
