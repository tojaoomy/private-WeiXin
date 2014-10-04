package com.tojaoomy.jupiter.common.entity.request.util;

import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meidusa.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.tojaoomy.jupiter.common.constant.JupiterConstants;
import com.tojaoomy.jupiter.common.entity.event.BaseEvent;
import com.tojaoomy.jupiter.common.entity.event.LocationEvent;
import com.tojaoomy.jupiter.common.entity.event.LocationNewEvent;
import com.tojaoomy.jupiter.common.entity.event.MenuEvent;
import com.tojaoomy.jupiter.common.entity.event.PictureEvent;
import com.tojaoomy.jupiter.common.entity.event.QRCodeEvent;
import com.tojaoomy.jupiter.common.entity.event.QRCodeNewEvent;
import com.tojaoomy.jupiter.common.entity.event.ScanCodeInfo;
import com.tojaoomy.jupiter.common.entity.event.SubscribeEvent;
import com.tojaoomy.jupiter.common.util.MessageUtil;

/**
 * 针对用户在微信触发的各种事件的请求处理工具 比如关注，取消关注，上传地理事件，扫描二维码，自定义菜单等等
 * 
 * @author hejian
 * 
 */
public class EventUtil {

	private static Logger logger = LoggerFactory.getLogger(EventUtil.class);

	/**
	 * 
	 * @param baseMessageRequest
	 *            需要设置参数的request
	 * @param requestMap
	 */

	private static void buildBaseEvent(BaseEvent baseEvent,
			Map<String, String> requestMap) {
		baseEvent.setFromUserName(requestMap.get(JupiterConstants.REQUEST_PARAMETER_FROM_USER_NAME));
		baseEvent.setToUserName(requestMap.get(JupiterConstants.REQUEST_PARAMETER_TO_USER_NAME));
		baseEvent.setMsgType(requestMap.get(JupiterConstants.REQUEST_PARAMETER_MSG_TYPE));
		baseEvent.setCreateTime(Long.valueOf(requestMap.get(JupiterConstants.REQUEST_PARAMETER_CREATE_TIME)));
		// 事件类型
		baseEvent.setEvent(requestMap.get(JupiterConstants.REQUEST_PARAMETER_EVENT));
	}

	/**
	 * 获取关注/取消关注请求对象
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @return
	 */
	public static SubscribeEvent getSubscribeEvent(
			Map<String, String> requestMap, HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		SubscribeEvent event = new SubscribeEvent();
		buildBaseEvent(event, requestMap);
		logger.info("返回  SubscribeEvent : " + JSONObject.toJSONString(event));
		return event;
	}

	/**
	 * 扫描带参数二维码事件请求对象
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @return
	 */
	public static QRCodeEvent getQRCodeEvent(Map<String, String> requestMap,
			HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		QRCodeEvent event = new QRCodeEvent();
		buildBaseEvent(event, requestMap);
		event.setEventKey(requestMap.get(JupiterConstants.REQUEST_PARAMETER_EVENT_KEY));
		event.setTicket(requestMap.get(JupiterConstants.REQUEST_PARAMETER_TICKET));
		logger.info("返回  QRCodeEvent : " + JSONObject.toJSONString(event));
		return event;
	}
	
	/**
	 * 扫描带参数二维码NEW事件请求对象
	 * 
	 * NOTE: 该对象的Event值只能是scancode_push | scancode_waitmsg
	 * 
	 * 为了简便起见，这个版本通过map来构建对象，下个版本可能使用xstream来构建对象
	 * 
	 * <code>
	 * 		XStream xs = new XStream(new XppDriver());
	 * 		xml 为request的XML格式文本内容
	 * 		QRCodeNewEvent msg = (QRCodeNewEvent)xs.fromXML(xml);
	 * </code>
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @see QRCodeNewEvent
	 * @return
	 */
	public static QRCodeNewEvent getQRCodeNewEvent(Map<String, String> requestMap,
			HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		QRCodeNewEvent event = new QRCodeNewEvent();
		buildBaseEvent(event, requestMap);
		event.setEventKey(requestMap.get(JupiterConstants.REQUEST_PARAMETER_EVENT_KEY));
		ScanCodeInfo scanCodeInfo = new ScanCodeInfo();
		scanCodeInfo.setScanType(requestMap.get(JupiterConstants.REQUEST_PARAMETER_SCAN_TYPE));
		scanCodeInfo.setScanResult(requestMap.get(JupiterConstants.REQUEST_PARAMETER_SCAN_RESULT));
		event.setScanCodeInfo(scanCodeInfo);
		logger.info("返回  QRCodeNewEvent : " + JSONObject.toJSONString(event));
		return event;
	}
	
	public static QRCodeNewEvent getQRCodeNewEventOverXstream(Map<String, String> requestMap,
			HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		XStream xs = new XStream(new MyXppDriver());
		xs.autodetectAnnotations(true);
		xs.alias("xml", QRCodeNewEvent.class);
		QRCodeNewEvent event = (QRCodeNewEvent)xs.fromXML(request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE).toString());
		logger.info("返回  QRCodeNewEvent : " + JSONObject.toJSONString(event));
		return event;
	}
	
	/**
	 * 发图片事件请求对象
	 * 
	 * NOTE: 该对象的Event值只能是pic_sysphoto | pic_photo_or_album | pic_weixin
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @see PictureEvent
	 * @return 
	 */
	public static PictureEvent getPictureEvent(Map<String, String> requestMap,
			HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		XStream xs = new XStream(new MyXppDriver());
		xs.autodetectAnnotations(true);
		xs.alias("xml", PictureEvent.class);
		PictureEvent event = (PictureEvent)xs.fromXML(request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE).toString());
		logger.info("返回  PictureEvent : " + JSONObject.toJSONString(event));
		return event;
	}

	/**
	 * 上报地理位置事件请求对象 用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置，
	 * 公众号可以在公众平台网站中修改以上设置。上报地理位置时，微信会将上报地理位置事件推送到开发者填写的URL
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @return
	 */
	public static LocationEvent getLocationEvent(Map<String, String> requestMap,
			HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		LocationEvent event = new LocationEvent();
		buildBaseEvent(event, requestMap);
		event.setLatitude(requestMap.get(JupiterConstants.REQUEST_PARAMETER_LATITUDE));
		event.setLongitude(requestMap.get(JupiterConstants.REQUEST_PARAMETER_LONGITUDE));
		event.setPrecision(requestMap.get(JupiterConstants.REQUEST_PARAMETER_PRECISIOIN));
		logger.info("返回  LocationEvent : " + JSONObject.toJSONString(event));
		return event;
	}
	
	/**
	 * 事件请求对象
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @return 
	 */
	public static LocationNewEvent getLocationNewEvent(Map<String, String> requestMap,
			HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		XStream xs = new XStream(new MyXppDriver());
		xs.autodetectAnnotations(true);
		xs.alias("xml", LocationNewEvent.class);
		LocationNewEvent event = (LocationNewEvent)xs.fromXML(request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE).toString());
		logger.info("返回  {} : {} ", LocationNewEvent.class.getName(),JSONObject.toJSONString(event));
		return event;
	}
	
	/**
	 * 事件请求对象
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @return 
	 */
	public static <T> T getNewEvent(Map<String, String> requestMap,
			HttpServletRequest request,Class<?> T) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		XStream xs = new XStream(new MyXppDriver());
		xs.autodetectAnnotations(true);
		xs.alias("xml", T);
		@SuppressWarnings("unchecked")
		T event = (T)xs.fromXML(request.getAttribute(MessageUtil.REQUEST_ATTRIBUTE).toString());
		logger.info("返回  {} : {} ", T.getClass().getName(),JSONObject.toJSONString(event));
		return event;
	}
	
	/**
	 * 用户点击自定义菜单后，微信会把点击事件推送给开发者，请注意，点击菜单弹出子菜单，不会产生上报
	 * 
	 * @param requestMap
	 *            微信发过来的参数map
	 * @param request
	 * @return
	 */
	public static MenuEvent getMenuEvent(Map<String, String> requestMap,
			HttpServletRequest request) {
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		MenuEvent event = new MenuEvent();
		buildBaseEvent(event, requestMap);
		event.setEventKey(requestMap.get(JupiterConstants.REQUEST_PARAMETER_EVENT_KEY));
		logger.info("返回  MenuEvent : " + JSONObject.toJSONString(event));
		return event;
	}
	
	static class MyXppDriver extends XppDriver{

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
	
}
