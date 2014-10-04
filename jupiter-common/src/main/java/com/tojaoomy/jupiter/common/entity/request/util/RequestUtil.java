package com.tojaoomy.jupiter.common.entity.request.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.meidusa.fastjson.JSONObject;
import com.tojaoomy.jupiter.common.constant.JupiterConstants;
import com.tojaoomy.jupiter.common.entity.request.BaseMessageRequest;
import com.tojaoomy.jupiter.common.entity.request.ImageMessageRequest;
import com.tojaoomy.jupiter.common.entity.request.LinkMessageRequest;
import com.tojaoomy.jupiter.common.entity.request.LocationMessageRequest;
import com.tojaoomy.jupiter.common.entity.request.TextMessageRequest;
import com.tojaoomy.jupiter.common.entity.request.VideoMessageRequest;
import com.tojaoomy.jupiter.common.entity.request.VoiceMessageRequest;

/**
 * 针对用户在输入框发送的请求处理工具
 * 
 * @author hejian
 *
 */
public class RequestUtil {
	
	private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);
	
	/**
	 * 
	 * @param baseMessageRequest 需要设置参数的request
	 * @param requestMap 
	 */
	
	private static void buildBaseMessageRequest(BaseMessageRequest messageRequest,Map<String, String> requestMap){
		messageRequest.setFromUserName(requestMap.get(JupiterConstants.REQUEST_PARAMETER_FROM_USER_NAME));
		messageRequest.setToUserName(requestMap.get(JupiterConstants.REQUEST_PARAMETER_TO_USER_NAME));
		messageRequest.setMsgType(requestMap.get(JupiterConstants.REQUEST_PARAMETER_MSG_TYPE));
		messageRequest.setCreateTime(Long.valueOf(requestMap.get(JupiterConstants.REQUEST_PARAMETER_CREATE_TIME)));
		messageRequest.setMsgId(Long.valueOf(requestMap.get(JupiterConstants.REQUEST_PARAMETER_MSG_ID)));
	}
	
	/**
	 * 获取文本消息请求对象
	 * 
	 * @param requestMap 微信发过来的参数map
	 * @param request
	 * @return 文本消息请求object
	 */
	public static TextMessageRequest getTextMessageRequest(Map<String, String> requestMap,
			HttpServletRequest request){
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		TextMessageRequest messageRequest = new TextMessageRequest();
		buildBaseMessageRequest(messageRequest, requestMap);
		messageRequest.setContent(requestMap.get(JupiterConstants.REQUEST_PARAMETER_CONTENT));
		logger.info("返回  TextMessageRequest : " + JSONObject.toJSONString(messageRequest));
		return messageRequest;
	}
	
	/**
	 * 获取图片消息请求对象
	 * 
	 * @param requestMap 微信发过来的参数map
	 * @param request
	 * @return 图片消息请求object
	 */
	public static ImageMessageRequest getImageMessageRequest(Map<String, String> requestMap,
			HttpServletRequest request){
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		ImageMessageRequest messageRequest = new ImageMessageRequest();
		buildBaseMessageRequest(messageRequest, requestMap);
		messageRequest.setPicUrl(requestMap.get(JupiterConstants.REQUEST_PARAMETER_PIC_URL));
		messageRequest.setMediaId(requestMap.get(JupiterConstants.REQUEST_PARAMETER_MEDIA_ID));
		logger.info("返回  ImageMessageRequest : " + JSONObject.toJSONString(messageRequest));
		return messageRequest;
	}
	
	/**
	 * 获取语音消息请求对象
	 * 
	 * @param requestMap 微信发过来的参数map
	 * @param request
	 * @return 语音消息请求object
	 */
	public static VoiceMessageRequest getVoiceMessageRequest(Map<String, String> requestMap,
			HttpServletRequest request){
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		VoiceMessageRequest messageRequest = new VoiceMessageRequest();
		buildBaseMessageRequest(messageRequest, requestMap);
		messageRequest.setMediaId(requestMap.get(JupiterConstants.REQUEST_PARAMETER_MEDIA_ID));
		messageRequest.setFormat(requestMap.get(JupiterConstants.REQUEST_PARAMETER_FORMAT));
		messageRequest.setRecognition(requestMap.get(JupiterConstants.REQUEST_PARAMETER_RECOGNITION));
		logger.info("返回  VoiceMessageRequest : " + JSONObject.toJSONString(messageRequest));
		return messageRequest;
	}
	
	/**
	 * 获取视频消息请求对象
	 * 
	 * @param requestMap 微信发过来的参数map
	 * @param request
	 * @return 视频消息请求object
	 */
	public static VideoMessageRequest getVideoMessageRequest(Map<String, String> requestMap,
			HttpServletRequest request){
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		VideoMessageRequest messageRequest = new VideoMessageRequest();
		buildBaseMessageRequest(messageRequest, requestMap);
		messageRequest.setMediaId(requestMap.get(JupiterConstants.REQUEST_PARAMETER_MEDIA_ID));
		messageRequest.setThumbMediaId(requestMap.get(JupiterConstants.REQUEST_PARAMETER_THUMB_MEDIA_ID));
		logger.info("返回  VideoMessageRequest : " + JSONObject.toJSONString(messageRequest));
		return messageRequest;
	}
	
	/**
	 * 获取地理消息请求对象
	 * 
	 * @param requestMap 微信发过来的参数map
	 * @param request
	 * @return 地理消息请求object
	 */
	public static LocationMessageRequest getLocationMessageRequest(Map<String, String> requestMap,
			HttpServletRequest request){
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		LocationMessageRequest messageRequest = new LocationMessageRequest();
		buildBaseMessageRequest(messageRequest, requestMap);
		//纬度
		messageRequest.setLocation_X(requestMap.get(JupiterConstants.REQUEST_PARAMETER_LOCATION_X));
		//经度
		messageRequest.setLocation_Y(requestMap.get(JupiterConstants.REQUEST_PARAMETER_LOCATION_Y));
		//缩约图
		messageRequest.setScale(requestMap.get(JupiterConstants.REQUEST_PARAMETER_SCALE));
		//地理位置
		messageRequest.setLabel(requestMap.get(JupiterConstants.REQUEST_PARAMETER_LABEL));
		logger.info("返回  LocationMessageRequest : " + JSONObject.toJSONString(messageRequest));
		return messageRequest;
	}
	
	/**
	 * 获取链接消息请求对象
	 * 
	 * @param requestMap 微信发过来的参数map
	 * @param request
	 * @return 链接消息请求object
	 */
	public static LinkMessageRequest getLinkMessageRequest(Map<String, String> requestMap,
			HttpServletRequest request){
		logger.info("请求参数 map : " + JSONObject.toJSONString(requestMap));
		LinkMessageRequest messageRequest = new LinkMessageRequest();
		buildBaseMessageRequest(messageRequest, requestMap);
		//标题
		messageRequest.setTitle(requestMap.get(JupiterConstants.REQUEST_PARAMETER_TITLE));
		//描述
		messageRequest.setDescription(requestMap.get(JupiterConstants.REQUEST_PARAMETER_DESCRIPTION));
		//url
		messageRequest.setUrl(requestMap.get(JupiterConstants.REQUEST_PARAMETER_URL));
		logger.info("返回  LinkMessageRequest : " + JSONObject.toJSONString(messageRequest));
		return messageRequest;
	}
	
}
