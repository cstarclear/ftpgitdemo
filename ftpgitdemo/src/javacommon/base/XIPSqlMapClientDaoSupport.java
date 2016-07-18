package javacommon.base; 

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

/** 
* @author wu junli

* @date : 2012-11-30 
* @version : 1.0
* 
*/
public class XIPSqlMapClientDaoSupport extends SqlMapClientDaoSupport implements ApplicationContextAware {

	protected ApplicationContext context;
    
	@Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;       
    }
	
	protected ApplicationContext getContext() {
    	return context;
    }
	
	public void choseSqlClient(String name) {
		SqlMapClient client = (SqlMapClient) getContext().getBean(name);
		setSqlMapClientTemplate(new SqlMapClientTemplate(client));
		afterPropertiesSet();
	}
}
