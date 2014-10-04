package com.tojaoomy.jupiter.common.entity.event;

/**
 * 自定义菜单针对开发者增加调起扫一扫、发图片、发地理位置等能力, 此类主要是针对发图片
 * 
 *  1.弹出系统拍照发图
 *	用户点击按钮后，微信客户端将调起系统相机，完成拍照操作后，将拍摄的相片发送给开发者，并推送事件给开发者，同时收起系统相机，随后可能会收到开发者下发的消息。
 *	2. 弹出拍照或者相册发图
 *	用户点击按钮后，微信客户端将弹出选择器供用户选择“拍照”或者“从手机相册选择”。用户选择后即走其他两种流程。
 *	3. 弹出微信相册发图器
 * 	用户点击按钮后，微信客户端将调起微信相册，完成选择操作后，将选择的相片发送给开发者的服务器，并推送事件给开发者，同时收起相册，随后可能会收到开发者下发的消息。
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
public class PictureEvent extends BaseEvent {

	/** 事件KEY值，由开发者在创建菜单时设定 */
	@XStreamAlias("EventKey")
	private String eventKey;

	@XStreamAlias("SendPicsInfo")
	private SendPicsInfo sendPicsInfo;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public SendPicsInfo getSendPicsInfo() {
		return sendPicsInfo;
	}

	public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
		this.sendPicsInfo = sendPicsInfo;
	}
	
}