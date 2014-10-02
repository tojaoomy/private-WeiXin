package com.tojaoomy.jupiter.common.constant;

/**
 * @author hejian
 *
 *@see http://mp.weixin.qq.com/wiki/index.php?title=%E9%AA%8C%E8%AF%81%E6%B6%88%E6%81%AF%E7%9C%9F%E5%AE%9E%E6%80%A7
 */
public class JupiterConstants {
    /** 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。*/
    public static final String SIGNATURE = "signature";
    
    /** 时间戳 */
    public static final String TIMESTAMP = "timestamp";
    
    /** 随机数 */
    public static final String NONCE = "nonce";
    
    /** 随机字符串 */
    public static final String ECHOSTR = "echostr";
    
    /** 微信服务器最大等待时间 */
    public static final int INTERNAL = 5;
    
    /** 发送方帐号参数（open_id） */
    public static final String REQUEST_PARAMETER_FROM_USER_NAME = "FromUserName";
    
    /** 公众帐号参数 */
    public static final String REQUEST_PARAMETER_TO_USER_NAME = "ToUserName";
    
    /** 消息类型 */
    public static final String REQUEST_PARAMETER_MSG_TYPE = "MsgType";
    
    /** 事件 */
    public static final String REQUEST_PARAMETER_EVENT = "Event";
    
    /** 事件Value */
    public static final String REQUEST_PARAMETER_EVENT_KEY = "EventKey";
    
    /** 第三方用户唯一凭证ID */  
    public final static String APPID =  "wx38a0b3a7cc7761f9";
    
    /** 第三方用户唯一凭证 secret*/  
    public final static String APPSECRET =  "04a4ea410735b9a134d41ed29ce64699";
   
}
