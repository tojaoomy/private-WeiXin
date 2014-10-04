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
    
    /** 消息创建时间 */
    public static final String REQUEST_PARAMETER_CREATE_TIME = "CreateTime";
    
    /** 消息ID */
    public static final String REQUEST_PARAMETER_MSG_ID = "MsgId";
    
    /** 消息内容 */
    public static final String REQUEST_PARAMETER_CONTENT = "Content";
    
    /** 图片链接 */
    public static final String REQUEST_PARAMETER_PIC_URL = "PicUrl";
    
    /** 图片消息媒体id，可以调用多媒体文件下载接口拉取数据  */
    public static final String REQUEST_PARAMETER_MEDIA_ID = "MediaId";
    
    /** 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据  */
    public static final String REQUEST_PARAMETER_THUMB_MEDIA_ID = "ThumbMediaId";
    
    /** 语音识别结果，UTF8编码  */
    public static final String REQUEST_PARAMETER_RECOGNITION = "Recognition";
    
    /** 语音格式，如amr，speex等  */
    public static final String REQUEST_PARAMETER_FORMAT = "Format";
    
    /** 事件类型  */
    public static final String REQUEST_PARAMETER_EVENT = "Event";
    
    /** 地理位置纬度  */
    public static final String REQUEST_PARAMETER_LOCATION_X = "Location_X";
    
    /** 地理位置经度  */
    public static final String REQUEST_PARAMETER_LOCATION_Y = "Location_Y";
    
    /** 地图缩放大小  */
    public static final String REQUEST_PARAMETER_SCALE = "Scale";
    
    /** 地理位置信息  */
    public static final String REQUEST_PARAMETER_LABEL = "Label";
    
    /** 链接消息标题  */
    public static final String REQUEST_PARAMETER_TITLE = "Title";
    
    /** 链接消息描述  */
    public static final String REQUEST_PARAMETER_DESCRIPTION = "Description";
    
    /** 消息链接  */
    public static final String REQUEST_PARAMETER_URL = "Url";
    
    /** 事件Value */
    public static final String REQUEST_PARAMETER_EVENT_KEY = "EventKey";
    
    /** 二维码的ticket，可用来换取二维码图片  */
    public static final String REQUEST_PARAMETER_TICKET = "Ticket";
    
    /** 扫描类型，一般是qrcode */
    public static final String REQUEST_PARAMETER_SCAN_TYPE = "ScanType";
    
    /** 扫描结果，即二维码对应的字符串信息 */
    public static final String REQUEST_PARAMETER_SCAN_RESULT = "ScanResult";
    
    /** 地理纬度  */
    public static final String REQUEST_PARAMETER_LATITUDE = "Latitude";
    
    /** 地理经度  */
    public static final String REQUEST_PARAMETER_LONGITUDE = "Longitude";
    
    /** 地理精度  */
    public static final String REQUEST_PARAMETER_PRECISIOIN = "Precision";
    
    /** 第三方用户唯一凭证ID */  
    //为测试号
    public final static String APPID =  "wx38a0b3a7cc7761f9";
    
    /** 第三方用户唯一凭证 secret*/  
    public final static String APPSECRET =  "04a4ea410735b9a134d41ed29ce64699";
   
}
