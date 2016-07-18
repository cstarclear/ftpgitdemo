package javacommon.ftp;

import java.io.IOException;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;

/**
 * ftp download
 * @author wangwch
 * @date 20100830
 * @version 1.0
 */
public class FtpDownload {

	/**
	 * 使用ftp下载文件
	 * @param remoteHost 远程IP地址
	 * @param port 端口，默认为21
	 * @param user 用户名
	 * @param password 密码 
	 * @param filePath 下载文件路径
	 * @param fileName 下载文件名
	 * @return 文件数据   byte[]
	 * @throws IOException
	 * @throws FTPException
	 */
	public static byte[] getFile(String remoteHost, int port, String user, String password, String filePath,
			String fileName) throws IOException, FTPException {

		FTPClient ftp = null;
		byte[] filebyte = null;

		// set up client
		ftp = new FTPClient();
		ftp.setRemoteHost(remoteHost);
		ftp.setRemotePort(port);

		ftp.connect();

		ftp.login(user, password);

		ftp.setConnectMode(FTPConnectMode.PASV);
		ftp.setType(FTPTransferType.BINARY);

		filebyte = ftp.get(filePath + fileName);

		ftp.quit();

		return filebyte;

	}

}