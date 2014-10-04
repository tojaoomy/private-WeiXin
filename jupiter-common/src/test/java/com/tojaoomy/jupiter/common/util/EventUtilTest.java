package com.tojaoomy.jupiter.common.util;

import java.io.Writer;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import com.meidusa.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.tojaoomy.jupiter.common.entity.event.LocationNewEvent;
import com.tojaoomy.jupiter.common.entity.event.PictureEvent;
import com.tojaoomy.jupiter.common.entity.event.QRCodeNewEvent;
import com.tojaoomy.jupiter.common.entity.event.ScanCodeInfo;
import com.tojaoomy.jupiter.common.entity.request.util.EventUtil;
import com.tojaoomy.jupiter.common.enumeration.EventType;

public class EventUtilTest {

	private static String xml = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>"
			+ "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>"
			+ "<CreateTime>1408090502</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[scancode_push]]></Event>"
			+ "<EventKey><![CDATA[6]]></EventKey>"
			+ "<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>"
			+ "<ScanResult><![CDATA[1]]></ScanResult>"
			+ "</ScanCodeInfo>"
			+ "</xml>";
	
	private static String xml_pic = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>"
			+ " <FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>"
			+ " <CreateTime>1408090816</CreateTime>"
			+ " <MsgType><![CDATA[event]]></MsgType>"
			+ " <Event><![CDATA[pic_weixin]]></Event>"
			+ " <EventKey><![CDATA[6]]></EventKey>"
			+ " <SendPicsInfo><Count>1</Count>"
			+ " <PicList><item><PicMd5Sum><![CDATA[5a75aaca956d97be686719218f275c6b]]></PicMd5Sum>"
			+ " </item>"
			+ " </PicList>"
			+ " </SendPicsInfo>"
			+ " </xml>";
	
	private static String xml_loc = "<xml><ToUserName><![CDATA[gh_e136c6e50636]]></ToUserName>"
			+ "<FromUserName><![CDATA[oMgHVjngRipVsoxg6TuX3vz6glDg]]></FromUserName>"
			+ "<CreateTime>1408091189</CreateTime>"
			+ "<MsgType><![CDATA[event]]></MsgType>"
			+ "<Event><![CDATA[location_select]]></Event>"
			+ "<EventKey><![CDATA[6]]></EventKey>"
			+ "<SendLocationInfo><Location_X><![CDATA[23]]></Location_X>"
			+ "<Location_Y><![CDATA[113]]></Location_Y>"
			+ "<Scale><![CDATA[15]]></Scale>"
			+ "<Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>"
			+ "<Poiname><![CDATA[]]></Poiname>"
			+ "</SendLocationInfo>"
			+ "</xml>";
	
	final MockHttpServletRequest request = new MockHttpServletRequest();
	
	@Before
	public void before(){
		request.setContent(xml.toString().getBytes());
	}
	
	@Test
	public void getQRCodeNewEventOverXstreamTest() throws Exception{
		QRCodeNewEvent codeNewEvent = EventUtil.getQRCodeNewEventOverXstream(MessageUtil.parseXml(request), request); 
		System.out.println("request.attribute : " + request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE));
		System.out.println(JSONObject.toJSONString(codeNewEvent));
		request.removeAttribute(MessageUtil.REQUEST_ATTRIBUTE);
	}
	
	@Test
	public void getPictureEventTest() throws Exception{
		request.setContent(xml_pic.toString().getBytes());
		PictureEvent pictureEvent = EventUtil.getPictureEvent(MessageUtil.parseXml(request), request); 
		System.out.println("request.attribute : " + request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE));
		System.out.println(JSONObject.toJSONString(pictureEvent));
		System.out.println(MessageUtil.messageToXml(pictureEvent));
		request.removeAttribute(MessageUtil.REQUEST_ATTRIBUTE);
	}
	
	@Test
	public void getLocationNewEventTest() throws Exception{
		request.setContent(xml_loc.toString().getBytes());
		LocationNewEvent event = EventUtil.getLocationNewEvent(MessageUtil.parseXml(request), request); 
		System.out.println("request.attribute : " + request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE));
		System.out.println(JSONObject.toJSONString(event));
		System.out.println(MessageUtil.messageToXml(event));
		request.removeAttribute(MessageUtil.REQUEST_ATTRIBUTE);
	}
	
	@Test
	public void getLocationEventTest() throws Exception{
		request.setContent(xml_loc.toString().getBytes());
		LocationNewEvent event = EventUtil.getNewEvent(MessageUtil.parseXml(request), request,LocationNewEvent.class); 
		System.out.println("request.attribute : " + request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE));
		System.out.println(JSONObject.toJSONString(event));
		System.out.println(MessageUtil.messageToXml(event));
		request.removeAttribute(MessageUtil.REQUEST_ATTRIBUTE);
	}
	
	@Test
	public void test(){
		QRCodeNewEvent event = new QRCodeNewEvent();
		event.setCreateTime(new Date().getTime());
		event.setEvent(EventType.SCANCODE_WAITMSG.code());
		event.setEventKey("HELLO");
		event.setFromUserName("12343");
		event.setMsgType("event");
		event.setToUserName("hhhaaha");
		ScanCodeInfo scanCodeInfo = new ScanCodeInfo();
		scanCodeInfo.setScanType("qrcode");
		scanCodeInfo.setScanResult("1");
		event.setScanCodeInfo(scanCodeInfo);
		XStream xs = new XStream(new MyXppDriver());
		xs.autodetectAnnotations(true);
		String content = MessageUtil.messageToXml(event);
		System.out.println(content);
		xs.alias("xml", event.getClass());
		event = (QRCodeNewEvent) xs.fromXML(content);
		System.out.println(JSONObject.toJSONString(event));
	}
}

class MyXppDriver extends XppDriver{

    /* (non-Javadoc)
     * @see com.thoughtworks.xstream.io.xml.XppDriver#createWriter(java.io.Writer)
     */
    @Override
    public HierarchicalStreamWriter createWriter(Writer out) {
        return new PrettyPrintWriter(out){
            /** 是否输出<![CDATA[]]>*/
            boolean cdata = true;
            
            /* (non-Javadoc)
             * @see com.thoughtworks.xstream.io.xml.PrettyPrintWriter#writeText(com.thoughtworks.xstream.core.util.QuickWriter, java.lang.String)
             */
            @Override
            protected void writeText(QuickWriter writer, String text) {
                if(cdata){
                    writer.write("<![CDATA[");
                    writer.write(text);
                    writer.write("]]>");
                }else{
                    super.writeText(writer, text);
                }
            }
        };
    }
}
