package com.tojaoomy.jupiter.common.entity.event;

/**
 * 自定义菜单针对开发者增加调起扫一扫、发图片、发地理位置等能力, 此类主要是针对扫一扫功能
 * 
 * 1. scancode_push：扫码推事件的事件推送 
 *用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后显示扫描结果（如果是URL，将进入URL），且会将扫码的结果传给开发者，开发者可以下发消息。
 * 2. scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件推送
 *用户点击按钮后，微信客户端将调起扫一扫工具，完成扫码操作后，将扫码的结果传给开发者，同时收起扫一扫工具，然后弹出“消息接收中”提示框，随后可能会收到开发者下发的消息。
 *
 * 该类的Event值分别对应scancode_push、scancode_waitmsg
 */
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @author hejian
 * 
 */
@XStreamAlias("xml")
public class QRCodeNewEvent extends BaseEvent {

	/** 事件KEY值，由开发者在创建菜单时设定 */
	@XStreamAlias("EventKey")
	private String eventKey;
	
	@XStreamAlias("ScanCodeInfo")
	private ScanCodeInfo scanCodeInfo;
	
	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public ScanCodeInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

}