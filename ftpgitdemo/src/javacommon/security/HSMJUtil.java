package javacommon.security;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 加密机工具类
 * @author xjm
 *
 */
public class HSMJUtil {
	
	private String ip;
	private String port;
	
	private InputStream iInputStream;
	private OutputStream iOutputStream;
	private Socket iSocketHandle;

	public HSMJUtil(String ip, String port){
		this.ip = ip;
		this.port = port;
	}
	
	public void connect() throws Exception {
		iSocketHandle = new Socket();
		//InetSocketAddress hsmAddr = new InetSocketAddress("188.0.36.13", 6666);
		InetSocketAddress hsmAddr = new InetSocketAddress(ip, Integer.parseInt(port));
		iSocketHandle.connect(hsmAddr, 10000);
		iSocketHandle.setSoTimeout(10000);
		iSocketHandle.setKeepAlive(true);
		iSocketHandle.setReceiveBufferSize(2048);
		iSocketHandle.setTcpNoDelay(true);
		iInputStream = iSocketHandle.getInputStream();
		iOutputStream = iSocketHandle.getOutputStream();
	}
	
	public void send(byte[] data) throws Exception {
		iOutputStream.write(data);
	}
	
	public int get(byte[] data) throws Exception {
		
        return iInputStream.read(data);
	}
	
	public void close() throws Exception {
		if(iOutputStream != null)
		    iOutputStream.close();
		
		if(iInputStream != null)
		    iInputStream.close();
		
		if(iSocketHandle != null)
		    iSocketHandle.close();
	}
	
    public static String byte2String(byte[] b){
    	String s = "";
    	for(int i=0;i<b.length;i++){
			int r = (int)b[i];
			if(r < 0) r = 256 + r;
			String tmp = Integer.toHexString(r);
			if(tmp.length() == 1 )
				tmp = "0" + tmp;
			s += tmp;
		}
    	
    	return s.toUpperCase();
    }
}
