package com.tojaoomy.jupiter.common.entity.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 事件基类
 * 
 * @author hejian
 *
 */
public abstract class BaseEvent {
    // 开发者微信号
    @XStreamAlias("ToUserName")
    private String toUserName;

    // 发送方帐号（一个OpenID）
    @XStreamAlias("FromUserName")
    private String fromUserName;

    // 消息创建时间 （整型）
    @XStreamAlias("CreateTime")
    private long createTime;

    // 消息类型（event）
    @XStreamAlias("MsgType")
    private String msgType="event";

    //事件类型(subscribe/unsubscribe/SCAN/LOCATION/CLICK/VIEW) Last three are Capital
    @XStreamAlias("Event")
    private String event;

    /**
     *
     *	Get the toUserName
     *
     * @return the toUserName
     */
    public String getToUserName() {
        return toUserName;
    }

    /**
     *
     *	Set the toUserName
     *
     * @param toUserName the toUserName to set
     */
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    /**
     *
     *	Get the fromUserName
     *
     * @return the fromUserName
     */
    public String getFromUserName() {
        return fromUserName;
    }

    /**
     *
     *	Set the fromUserName
     *
     * @param fromUserName the fromUserName to set
     */
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    /**
     *
     *	Get the createTime
     *
     * @return the createTime
     */
    public long getCreateTime() {
        return createTime;
    }

    /**
     *
     *	Set the createTime
     *
     * @param createTime the createTime to set
     */
    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    /**
     *
     *	Get the msgType
     *
     * @return the msgType
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     *
     *	Set the msgType
     *
     * @param msgType the msgType to set
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
     *
     *	Get the event
     *
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     *
     *	Set the event
     *
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }
}
