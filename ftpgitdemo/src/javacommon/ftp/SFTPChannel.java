package javacommon.ftp;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/** 
* @author zb

* @date : 2012-8-22 
* @version : 1.0
* 
*/
public class SFTPChannel {
	private static Logger logger = LoggerFactory.getLogger(SFTPChannel.class);
	Session session = null;
	Channel channel = null;
	ChannelSftp sftp =null;

	public ChannelSftp getChannel(String user, String remoteHost, int port, String password) throws Exception {
		JSch jsch = new JSch();
		session = jsch.getSession(user, remoteHost, port);
		logger.info("Session created.");
		session.setPassword(password);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		logger.info("before Session connect.");
		session.connect();
		logger.info("Session connected.");
		logger.info("Opening Channel.");
		channel = session.openChannel("sftp"); // 打开SFTP通道
		channel.connect(); // 建树SFTP通道的连接
		logger.info("channel connected");
		sftp = (ChannelSftp)channel;
		return sftp;
	}
	
	 public void closeChannel() throws Exception {
	        if (channel != null) {
	            channel.disconnect();
	        }
	        if (session != null) {
	            session.disconnect();
	        }
	    }

}
