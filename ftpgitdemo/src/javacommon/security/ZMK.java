package javacommon.security;

import com.allinpay.util.PropertiesUtils;

/**
 * 使用加密机进行tmk加密
 * @author xjm
 *
 */
public class ZMK {


	private String ip = "";//暂时写死

	private String port = "";//暂时写死

	private final int MAX_LENGTH = 2048;

	/**
	 * D181 
	 * 0001
	 * 0000
	 * 01
	 */
	private final static byte[] heads = new byte[] { (byte) 0xD1, (byte) 0x81, (byte) 0x00, (byte) 0x01, (byte) 0x00,
			(byte) 0x00, (byte) 0x01 };

	public ZMK() {

	}

	/**
	 * 生成密钥，随机数由该函数产生
	 * @param mchtCd
	 * @param termId
	 * @return
	 * @throws Exception 
	 */
	public byte[] getZMK(String companyCd, String mchtCd, String termId, String random) throws Exception {

		/**
		 * 去掉空格
		 */
		companyCd = companyCd.trim();
		mchtCd = mchtCd.trim();
		termId = termId.trim();
		random = random.trim();

		/**
		 * 产生发送数据
		 */
		// 分散因子1--机构号
		String data1 = companyCd;
		int len1 = companyCd.length();

		// 分散因子2--商户号+终端号+随机数
		String data2 = mchtCd + termId + random;
		int len2 = data2.length();

		/**
		 * 检查长度
		 */
		// 分散因子1：1-11位
		if (len1 < 1 || len1 > 11)
			throw new Exception("分散因子1长度错误:" + len1);

		// 分散因子2：1-29位
		if (len2 < 1 || len2 > 29)
			throw new Exception("分散因子2长度错误:" + len2);

		// 总长度：头+分散因子1长度(1)+分散因子1+分散因子2长度(1)+分散因子2
		int totalLen = heads.length + 1 + data1.length() + 1 + data2.length();
		byte[] data = new byte[totalLen];
		System.arraycopy(heads, 0, data, 0, heads.length);
		int currIndex = heads.length;
		data[currIndex++] = (byte) len1;
		for (int i = 0; i < data1.length(); i++) {
			data[currIndex++] = (byte) data1.charAt(i);
		}
		data[currIndex++] = (byte) len2;
		for (int i = 0; i < data2.length(); i++) {
			data[currIndex++] = (byte) data2.charAt(i);
		}

		/**
		 * 连接加密机
		 */
		//    	ip = (String)ExtConfig.CONIFG.get(Constants.HSMJ_IP);
		//    	port = (String)ExtConfig.CONIFG.get(Constants.HSMJ_PORT);

		ip = PropertiesUtils.getGlobalProperties("HSMJ_IP");
		port = PropertiesUtils.getGlobalProperties("HSMJ_PORT");
		HSMJUtil hsmj = new HSMJUtil(ip, port);
		byte[] results = null;
		try {
			byte[] tmp = new byte[MAX_LENGTH];
			hsmj.connect();
			hsmj.send(data);
			int readLen = hsmj.get(tmp);
			results = new byte[readLen];

			System.arraycopy(tmp, 0, results, 0, readLen);
		} catch (Exception ex) {
			throw ex;
		} finally {
			hsmj.close();
		}

		/**
		 * 检查加密机应答
		 */
		// 41开头代表成功，10代表长度，共26字节
		if (results.length != 26 && results[0] != 0x41 || results[1] != 0x10)
			throw new Exception("zmk error，response：" + results);

		/**
		 * 只返回密钥+checkvalue
		 */
		byte[] ret = new byte[24];
		System.arraycopy(results, 2, ret, 0, 24);

		return ret;

	}

	public static void main(String[] args) {
		//    	//产生随机数
		//    	String random = Integer.toString((int)(Math.random()*999999));
		//    	if(random.length() < 6)
		//    		random = CommonFunction.fillString(random, '0', 6, false);
		//    	System.out.println(random);

		try {
			ZMK zmk = new ZMK();
			zmk.getZMK("99992900", "309310153110000", "00000000", "123456");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
