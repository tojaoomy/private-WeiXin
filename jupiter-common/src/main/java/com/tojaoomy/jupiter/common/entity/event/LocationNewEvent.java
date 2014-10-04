package com.tojaoomy.jupiter.common.entity.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 上报地理位置事件
 * 
 * @author hejian
 * 
 */
@XStreamAlias("xml")
public class LocationNewEvent extends BaseEvent {
	/** 事件KEY值，由开发者在创建菜单时设定 */
	@XStreamAlias("EventKey")
	private String eventKey;
	
    /** 地理位置信息  */
    @XStreamAlias("SendLocationInfo")
    private SendLocationInfo sendLocationInfo;

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public SendLocationInfo getSendLocationInfo() {
		return sendLocationInfo;
	}

	public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
		this.sendLocationInfo = sendLocationInfo;
	}
    
}
