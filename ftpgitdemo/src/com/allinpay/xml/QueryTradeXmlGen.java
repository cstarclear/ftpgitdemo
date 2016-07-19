package com.allinpay.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.allinpay.model.PayOrder;
import com.allinpay.util.DateUtil;

public class QueryTradeXmlGen {
	
	//通联的接入机构码
	public static String INS_CODE="8010105";
	//订单查询业务类型
	public static String BUSINESS_CODE="QUERYTRADE";
	
	private static String BU_REQUEST="1"; //请求
	private static String BU_RESPONSE="2"; //应答
	private static String BU_RESULT="3";  //结果
	
	public static Document xmlGen(java.util.List<PayOrder> payOrderList){
		Document document = DocumentHelper.createDocument();
		Element message = document.addElement("MESSAGE");
		//WA_COMON_010000
		Element dateset_1 = message.addElement("DATESET");
		dateset_1.setAttributeValue("name", "WA_COMMON_010000");
		dateset_1.setAttributeValue("rmk", "消息通用信息");
		Element data = dateset_1.addElement("DATA");
		//apptype
		Element apptype = data.addElement("ITEM");
		apptype.setAttributeValue("key", "apptype");
		apptype.setAttributeValue("val", "xxx");
		apptype.setAttributeValue("rmk", "应用编码，字典码");
		//opcode
		Element opcode = data.addElement("ITEM");
		opcode.setAttributeValue("key", "opcode");
		opcode.setAttributeValue("val", "QUERYTRADE");
		opcode.setAttributeValue("rmk", "业务类型");
		//msgtype
		Element msgtype = data.addElement("ITEM");
		msgtype.setAttributeValue("key", "msgtype");
		msgtype.setAttributeValue("val", "2");
		msgtype.setAttributeValue("rmk", "消息类型，1 请求，2 应答，3 结果");
		//opid
		Element opid = data.addElement("ITEM");
		opid.setAttributeValue("key", "opid");
		opid.setAttributeValue("val", "xxx");
		opid.setAttributeValue("rmk", "业务编号，和请求的业务编号相同");
		//WA_COMMON-010004
		Element dateset_2 = message.addElement("DATESET");
		dateset_2.setAttributeValue("name", "WA_COMMON_010004");
		dateset_2.setAttributeValue("rmk", "消息返回状态信息");
		Element data_2 = dateset_2.addElement("DATA");
		//status
		Element status = data_2.addElement("ITEM");
		status.setAttributeValue("key", "status");
		status.setAttributeValue("val", "0");
		status.setAttributeValue("rmk", "消息状态，0 成功，1 失败");
		//timestamp
		Element timestamp = data_2.addElement("ITEM");
		timestamp.setAttributeValue("key", "timestamp");
		timestamp.setAttributeValue("val", "1439914921");
		timestamp.setAttributeValue("rmk", "消息返回时间");
		//errorcode
		Element errorcode = data_2.addElement("ITEM");
		errorcode.setAttributeValue("key", "errorcode");
		errorcode.setAttributeValue("val", "0");
		errorcode.setAttributeValue("rmk", "业务消息错误码，0 正确，其他参考字典码。");
		//WA_COMMON_010012
		Element dateset_3 = message.addElement("DATESET");
		dateset_3.setAttributeValue("name", "WA_COMMON_010012");
		dateset_3.setAttributeValue("rmk", "结果数据");
		for(PayOrder po:payOrderList){
			Element data_3 = dateset_3.addElement("data");
			data_3.addElement("user_account").addText(po.getPayCustAcct());
			data_3.addElement("seller_account").addText(po.getColCustAcct());
			data_3.addElement("money").addText(po.getTransAmount()!=null?po.getTransAmount().toString():"0");
			data_3.addElement("create_time").addText(po.getCreateTimeString());
			data_3.addElement("pay_type").addText(po.getPayType());
			data_3.addElement("trade_type").addText(po.getTradeType());
//			data_3.addElement("remark").addText();
			data_3.addElement("goodsinfo").addText(po.getTardeName());
//			data_3.addElement("mac_address").addText(po.getPayCustAcct());
//			data_3.addElement("receiver_address").addText(po.getColCustName());
			data_3.addElement("seller_name").addText(po.getColCustName());
			data_3.addElement("serial_num").addText(po.getAllinpayOrderId());
			data_3.addElement("order_num").addText(po.getOrderId());
			data_3.addElement("goods_num").addText(po.getPackageId());
//			data_3.addElement("lastday_earnings").addText(po.getPayCustAcct());
//			data_3.addElement("all_earnings").addText(po.getPayCustAcct());
//			data_3.addElement("tenthousand_earnings").addText(po.getPayCustAcct());
//			data_3.addElement("ass_asset").addText(po.getPayCustAcct());
			data_3.addElement("query_time").addText(DateUtil.getToday());
			data_3.addElement("query_ip").addText("Ip:xxx.xxx.xxx.xxx");
			data_3.addElement("query_port").addText("Port:8080");
		}
		return document;
	}

}
