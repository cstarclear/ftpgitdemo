package javacommon.tcp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * tcp初始化.
 * @author wujl
 *
 */
public class TcpInitListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(TcpInitListener.class);

	/**
	 * 初始化tcp参数
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		
		// 和inter通信的报文结构
//		logger.info("初始化xmap.xml参数");
//
//		try {
//			XMapper.init("/com/globebill/tcp/data/xmap.xml");
//		} catch (XMapException ex) {
//			throw new RuntimeException("XMapper init failed.", ex);
//		}
//
//		logger.info("初始化xmap.xml参数成功.");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
