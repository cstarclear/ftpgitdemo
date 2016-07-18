package javacommon.base; 

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.funee.framework.page.Page;
import org.funee.framework.page.PageRequest;
import org.funee.framework.util.MapAndObject;


/** 
* @author MJ~

* @date : 2013-6-17 
* @version : 1.0
* 
*/
public abstract class TermIbatisDao<E, PK extends Serializable> extends XIPSqlMapClientDaoSupport implements EntityDao<E, PK> {

	protected final Log log = LogFactory.getLog(getClass());

	public abstract Class getEntityClass();

	/**
	 * 根据主键id，查询记录
	 */
	public Object getById(PK primaryKey) {
		choseSqlClient("sqlMapClientTerm");
		return getSqlMapClientTemplate().queryForObject(getFindByPrimaryKeyQuery(), primaryKey);
	}

	/**
	 * 根据主键id，删除记录
	 */
	public void deleteById(PK id) {
		choseSqlClient("sqlMapClientTerm");
		getSqlMapClientTemplate().delete(getDeleteQuery(), id);
	}

	/**
	 * 保存记录
	 */
	public void save(E entity) {
		choseSqlClient("sqlMapClientTerm");
		prepareObjectForSaveOrUpdate(entity);
		Object primaryKey = getSqlMapClientTemplate().insert(getInsertQuery(), entity);
	}

	/**
	 * 修改记录
	 */
	public void update(E entity) {
		choseSqlClient("sqlMapClientTerm");
		prepareObjectForSaveOrUpdate(entity);
		Object primaryKey = getSqlMapClientTemplate().update(getUpdateQuery(), entity);
	}

	/**
	 * 用于子类覆盖,在insert,update之前调用
	 * 
	 * @param o
	 */
	protected void prepareObjectForSaveOrUpdate(E o) {
	}

	public String getFindByPrimaryKeyQuery() {
		return getEntityClass().getSimpleName() + ".getById";
	}

	public String getInsertQuery() {
		return getEntityClass().getSimpleName() + ".insert";
	}

	public String getUpdateQuery() {
		return getEntityClass().getSimpleName() + ".update";
	}

	public String getDeleteQuery() {
		return getEntityClass().getSimpleName() + ".delete";
	}

	public String getSelectQuery() {
		return getEntityClass().getSimpleName() + ".select";
	}

	public String getCountQuery() {
		return getEntityClass().getSimpleName() + ".count";
	}

	/**
	 * 分页查询记录
	 * 
	 * @param statementName
	 * @param pageRequest
	 * @return
	 */
	protected Page pageQuery(String statementName, PageRequest pageRequest) {
		choseSqlClient("sqlMapClientTerm");
		//符合条件的总记录数
		Number totalCount = (Number) this.getSqlMapClientTemplate().queryForObject(getCountQuery(),
				pageRequest.getFilters());
		//分页对象
		Page page = new Page(pageRequest, totalCount.intValue());
		// 与getSqlMapClientTemplate().queryForList(statementName,
		// parameterObject)配合使用
		Map otherFilters = new HashMap();
		//页起始记录数
		otherFilters.put("offset", page.getFirstResult());
		//分页大小
		otherFilters.put("pageSize", page.getPageSize());
		//页结束记录数
		otherFilters.put("lastRows", page.getFirstResult() + page.getPageSize());
		//排序信息
		otherFilters.put("sortColumns", pageRequest.getSortColumns());
		// 混合两个filters为一个filters,MapAndObject.get()方法将在两个对象取值,Map如果取值为null,则再在Bean中取值
		Map parameterObject = new MapAndObject(otherFilters, pageRequest.getFilters());
		//分页查询
		List list = getSqlMapClientTemplate().queryForList(statementName, parameterObject, page.getFirstResult(),
				page.getPageSize());
		page.setResult(list);
		return page;
	}

	/**
	 * 取得所有表记录 根据查询条件
	 * @return List<E> entity 表的modle对象
	 */
	public List findAll(E entity) {
		choseSqlClient("sqlMapClientTerm");
		return getSqlMapClientTemplate().queryForList(getSelectQuery(), entity);
	}

	/**
	 * 是否为唯一记录，暂时不使用，可在继承类扩展
	 */
	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}

	public void flush() {
		// ignore
	}
}

