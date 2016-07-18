package com.allinpay.api.quartz; 

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javacommon.ftp.SFTPChannel;
import javacommon.ggpt.BaseRestService;

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
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

/** 
* @author jinwf

* @date : 2016-7-18 
* @version : 1.0
* 
*/
@Component
public class PayOrderQuartz extends BaseRestService{
	
	@Autowired
	private PayOrderManager payOrderManager;
	
    private String localfilename;
   
    private String remotefilename;
   
    private ChannelSftp channelSftp;
	
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
	
	public void work(){
		String filetmp = PropertiesUtils.getGlobalProperties("filetmp");
		String csvFilePath_2 = "";
	
      System.out.println("wo kao ,tai bang le ");
      //将生成的文件上传
      List<PayOrder> list = payOrderManager.findAll(new java.util.HashMap());
      
      Document document = DocumentHelper.createDocument();
      document.setXMLEncoding("UTF-8");
	  Element root = document.addElement("Payorders");
	  for(PayOrder po:list){
		  Element order = root.addElement("Payorders");
		  order.addElement("orderId").addText(po.getOrderId());
	  }
	  try {
		FileUtils.writeStringToFile(new File(filetmp), document.asXML());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      /*
       * 使用默认的端口号、用户名、密码以及根目录连接FTP服务器
       */
      String ftpServer = PropertiesUtils.getGlobalProperties("ftpBankServer");
      String ftpUser = PropertiesUtils.getGlobalProperties("ftpBankUser");
      String ftpPwd = PropertiesUtils.getGlobalProperties("ftpBankPwd");
      String ftpUrl = PropertiesUtils.getGlobalProperties("ftpBankPath");
      SFTPChannel sftpChannel = new SFTPChannel();
      try{
    	  channelSftp = sftpChannel.getChannel(ftpUser, ftpServer, 22, ftpPwd);
          File ftpU = new File(ftpUrl);
          if(!ftpU.exists())
        	  ftpU.mkdir();
          //上传文件
          String remotefile = ftpUrl+"/"+DateUtil.getToday()+"_total.csv";
          upload(filetmp, remotefile);
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

}

