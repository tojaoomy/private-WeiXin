package com.tojaoomy.jupiter.common.enumeration;

/**
 * to define the Event type enumeration.
 * 
 * @see ButtonType
 * 
 * @author hejian
 * 
 */
public enum EventType {
	/**
	 * 事件类型subscribe 订阅
	 * 
	 */
	SUBSCRIBE("subscribe"),
	
	/**
	 * 事件类型unsubscribe 取消订阅
	 * 
	 */
	
	UNSUBSCRIBE("unsubscribe"),
	
	/**
	 * 事件类型CLICK
	 * 
	 */
	SCAN("SCAN"),
	
	/**
	 * 事件类型LOCATION
	 * 
	 */
	LOCATION("LOCATION"),

	/**
	 * 事件类型VIEW
	 * 
	 */
	VIEW("VIEW"),

	/**
	 * 事件类型scancode_push 扫码推事件
	 */
	SCANCODE_PUSH("scancode_push"),

	/**
	 * 事件类型scancode_waitmsg 扫码推事件且弹出“消息接收中”提示框
	 */
	SCANCODE_WAITMSG("scancode_waitmsg"),

	/**
	 * 事件类型pic_sysphoto 弹出系统拍照发图
	 * 
	 */
	PIC_SYSPHOTO("pic_sysphoto"),

	/**
	 * 事件类型pic_photo_or_album 弹出拍照或者相册发图
	 */
	PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),

	/**
	 * 事件类型，pic_weixin 弹出微信相册发图器
	 */
	PIC_WEIXIN("pic_weixin"),

	/**
	 * 事件类型，location_select 弹出地理位置选择器
	 */
	LOCATIOIN_SELECT("location_select");

	private String code;

	private EventType(String code) {
		this.code = code;
	}

	/**
	 * 
	 * Get the code
	 * 
	 * @return the code
	 */
	public String code() {
		return code;
	}

	/**
	 * 
	 * Set the code
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.code;
	}

}
