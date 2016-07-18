package javacommon.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 数据库持久层类(Dao),定义了数据的基本CRUD方法
 * @author wfun
 */
public interface EntityDao<E, PK extends Serializable> {
	/**
	 * 根据主键 查询表信息
	 * @param id
	 * @return 表的modle对象
	 */
	public Object getById(PK id);

	/**
	 * 根据主键 删除表信息
	 * @param id
	 */
	public void deleteById(PK id);

	/**
	 * 保存数据记录
	 * @param entity 表的modle对象
	 */
	public void save(E entity);

	/**
	 * 修改数据记录
	 * @param entity 表的modle对象
	 */
	public void update(E entity);

	/**
	 * 保存或修改数据记录
	 * @param entity 表的modle对象
	 */
	public void saveOrUpdate(E entity);

	/**
	 * 是否为唯一记录
	 * @param entity  表的modle对象
	 * @param uniquePropertyNames
	 * @return
	 */
	public boolean isUnique(E entity, String uniquePropertyNames);

	/**
	 * 输出缓冲区的内容
	 */
	public void flush();

	/**
	 * 取得所有表记录
	 * @param Map whereCondition 查询条件
	 * @return List<E> entity  表的modle对象
	 */
	public List<E> findAll(Map whereCondition);

}
