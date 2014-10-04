package com.tojaoomy.jupiter.common.util;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.meidusa.fastjson.JSONObject;

public class MessageUtilTest {
	public static final String XML_CONTENT = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>"
			+ "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>"
			+ "<CreateTime>1408090502</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[scancode_push]]></Event>"
			+ "<EventKey><![CDATA[6]]></EventKey>"
			+ "<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>"
			+ "<ScanResult><![CDATA[1]]></ScanResult>"
			+ "<ScanImage><A><A1><B>BBBB</B></A1><A2>A2</A2><A3>A3</A3></A></ScanImage>"
			+ "</ScanCodeInfo>"
			+ "</xml>";
	final MockHttpServletRequest request = new MockHttpServletRequest();
	final MockHttpServletResponse response = new MockHttpServletResponse();
	
	@Before
	public void before(){
		request.setContent(XML_CONTENT.toString().getBytes());
	}
	@Test
	public void parseXmlTest(){
		try {
			Map<String, String> map = MessageUtil.parseXml(request);
			System.out.println(JSONObject.toJSONString(map));
			System.out.println("request attribute : " + request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE));
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			request.removeAttribute(MessageUtil.REQUEST_ATTRIBUTE);
		}
	}
}
