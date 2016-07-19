package com.allinpay.api.quartz; 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javacommon.ftp.FtpDownload;
import javacommon.ftp.SFTPChannel;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.allinpay.service.PayOrderManager;
import com.allinpay.model.PayOrder;
import com.allinpay.util.DateUtil;
import com.allinpay.util.PropertiesUtils;
import com.allinpay.xml.QueryTradeXmlGen;
import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

/** 
* @author jinwf

* @date : 2016-7-18 
* @version : 1.0
* 
*/
@Component
public class PayOrderQuartz{
	
	@Autowired
	private PayOrderManager payOrderManager;
	
    private String localfilename;
   
    private String remotefilename;
   
    private ChannelSftp channelSftp;
    
    private FTPClient ftp;
	
	public void upload(String localFile, String remoteFile) {
        this.localfilename = localFile;
        this.remotefilename = remoteFile;
        OutputStream os = null;
        FileInputStream is = null;
        try {
            //将远程文件加入输出流中  普通ftp
            os = channelSftp.put(this.remotefilename);
            
            //获取本地文件的输入流
            File file_in = new File(this.localfilename);
            is = new FileInputStream(file_in);
            //创建一个缓冲区
            byte[] bytes = new byte[1024];
            int c;
            while ((c = is.read(bytes)) != -1) {
                os.write(bytes, 0, c);
            }
           // System.out.println("upload success");
        } catch (IOException ex) {
           // System.out.println("not upload");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } catch(SftpException ea){
        	ea.printStackTrace();
        }finally{
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(os != null){
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public void work() throws IOException, FTPException{
		String downpath = PropertiesUtils.getGlobalProperties("downpath");
		String ftpServer = PropertiesUtils.getGlobalProperties("ftpServer");
		String ftpUser = PropertiesUtils.getGlobalProperties("ftpUser");
		String ftpPwd = PropertiesUtils.getGlobalProperties("ftpPwd");
		String ftpPath = PropertiesUtils.getGlobalProperties("ftpPath");
		FTPClient ftp = null;
		ftp = new FTPClient();
		ftp.setRemoteHost(ftpServer);
		ftp.setRemotePort(21);
		ftp.connect();
		ftp.login(ftpUser, ftpServer);
		
		ftp.setConnectMode(FTPConnectMode.PASV);
		ftp.setType(FTPTransferType.BINARY);

		//遍历ftp服务器上所有请求查询的文件，并下载下来
		String[] llftp = ftp.dir(ftpPath);
		for(String fmt:llftp){
			if(fmt.indexOf(QueryTradeXmlGen.INS_CODE+"_"+QueryTradeXmlGen.BUSINESS_CODE+"_1")!=-1){
				File newFile = new File(downpath+fmt);
				if(!newFile.exists()){
					newFile.createNewFile();
				}
				FileOutputStream out = new FileOutputStream(newFile);
				out.write(FtpDownload.getFile(ftpServer, 22, ftpUser, ftpPwd, ftpPath, fmt));
				out.close();
			}
		}
		ftp.quit();
		
		//根据下载下来的文件解析出查询条件，并查询出结果
		List<PayOrder> list = payOrderManager.findAll(new java.util.HashMap());
		String tradefile = PropertiesUtils.getGlobalProperties("tradefile");
		String descfile = PropertiesUtils.getGlobalProperties("descfile");
		// 将生成的文件上传
		
		try {
			FileUtils.writeStringToFile(new File(tradefile), QueryTradeXmlGen.xmlGen(list).asXML());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      /*
       * 使用默认的端口号、用户名、密码以及根目录连接SFTP服务器
       */
      String sftpServer = PropertiesUtils.getGlobalProperties("sftpServer");
      String sftpUser = PropertiesUtils.getGlobalProperties("sftpUser");
      String sftpPwd = PropertiesUtils.getGlobalProperties("sftpPwd");
      String sftpUrl = PropertiesUtils.getGlobalProperties("sftpPath");
      SFTPChannel sftpChannel = new SFTPChannel();
      try{
    	  channelSftp = sftpChannel.getChannel(sftpUser, sftpServer, 22, sftpPwd);
          File ftpU = new File(sftpUrl);
          if(!ftpU.exists())
        	  ftpU.mkdir();
          //上传文件
          String remotefile = sftpUrl+"/"+descfile;
          upload(tradefile, remotefile);
      }catch(Exception e){
    	  e.printStackTrace();
      } finally{
    	  try {
			sftpChannel.closeChannel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      } 
      
	}
	
	public static void main(String[] param) throws IOException, FTPException{
		String downpath = "d://tmp/";
		String ftpServer = "192.168.1.72";
		String ftpUser = "tomcat";
		String ftpPwd = "tomcat72";
		String ftpUrl = "/home/tomcat";
		FTPClient ftp = null;
		ftp = new FTPClient();
		ftp.setRemoteHost(ftpServer);
		ftp.setRemotePort(22);
		ftp.connect();
		ftp.login(ftpUser, ftpServer);
		
		ftp.setConnectMode(FTPConnectMode.PASV);
		ftp.setType(FTPTransferType.BINARY);

		String[] llftp = ftp.dir(ftpUrl);
		for(String fmt:llftp){
			if(fmt.indexOf(QueryTradeXmlGen.INS_CODE+"_"+QueryTradeXmlGen.BUSINESS_CODE+"_1")!=-1){
				File newFile = new File(downpath+fmt);
				if(!newFile.exists()){
					newFile.createNewFile();
				}
				FileOutputStream out = new FileOutputStream(newFile);
				out.write(FtpDownload.getFile(ftpServer, 22, ftpUser, ftpPwd, ftpUrl, fmt));
				out.close();
			}
		}
		ftp.quit();
		return;
	}

}

