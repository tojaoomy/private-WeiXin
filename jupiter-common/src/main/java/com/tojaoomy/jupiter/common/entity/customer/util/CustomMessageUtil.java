package com.tojaoomy.jupiter.common.entity.customer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

import com.tojaoomy.jupiter.common.entity.customer.BaseCustomMessage;
import com.tojaoomy.jupiter.common.util.CommonUtil;

public class CustomMessageUtil {
	
	private static final String URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	
	private static Logger logger = LoggerFactory.getLogger(CustomMessageUtil.class); 
	
	public static boolean sendCustomMessage(String accessToken,BaseCustomMessage message){
		boolean result = false;
		String requestUrl = URL.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", com.meidusa.fastjson.JSONObject.toJSONString(message));
		if(null != jsonObject){
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if(0 == errorCode){
				result = true;
				logger.info("客服消息发送成功 errcode : {} errmsg : {}", errorCode, errorMsg);
			}else{
				logger.error("客服消息发送失败 errcode : {} errmsg : {}", errorCode, errorMsg);
			}
		}
		return result;
	}
}
