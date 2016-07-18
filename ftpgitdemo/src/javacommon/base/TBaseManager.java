package javacommon.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 基本的业务流程逻辑的抽象类,实现业务流程的控制;
 * 实现了基于表的CRUD
 * @author wfun
 */
public abstract class TBaseManager<E, PK extends Serializable> {
	//日志变量
	protected Log log = LogFactory.getLog(getClass());

	//调用的dao类，需继承类实现
	protected abstract EntityDao getEntityDao();

	/**
	 * 根据主键 查询表信息
	 * @param id
	 * @return 表的modle对象
	 */
	public E getById(PK id) {
		return (E) getEntityDao().getById(id);
	}

	/**
	 * 取得所有表记录
	 * @param Map whereCondition 查询条件
	 * @return List<E> entity  表的modle对象
	 */
	public List<E> findAll(Map whereCondition) {
		return getEntityDao().findAll(whereCondition);
	}

	/**
	 * 保存或修改数据记录
	 * @param entity 表的modle对象
	 */
	public void saveOrUpdate(E entity) {
		getEntityDao().saveOrUpdate(entity);
	}

	/**
	 * 保存数据记录
	 * @param entity 表的modle对象
	 */
	public void save(E entity) {
		getEntityDao().save(entity);
	}

	/**
	 * 根据主键 删除表信息
	 * @param id
	 */
	public void removeById(PK id) {
		getEntityDao().deleteById(id);
	}

	/**
	 * 修改数据记录
	 * @param entity 表的modle对象
	 */
	public void update(E entity) {
		getEntityDao().update(entity);
	}

	/**
	 * 是否为唯一记录
	 * @param entity  表的modle对象
	 * @param uniquePropertyNames
	 * @return
	 */
	public boolean isUnique(E entity, String uniquePropertyNames) {
		return getEntityDao().isUnique(entity, uniquePropertyNames);
	}
}
