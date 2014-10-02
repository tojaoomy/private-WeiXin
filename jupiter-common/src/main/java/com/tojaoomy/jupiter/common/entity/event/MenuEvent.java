package com.tojaoomy.jupiter.common.entity.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 菜单事件
 * @author hejian
 *
 */
@XStreamAlias("xml")
public class MenuEvent extends BaseEvent {

    /** 事件KEY值，与自定义菜单接口中KEY值对应 */
    @XStreamAlias("EventKey")
    private String eventKey;

    /**
     *
     *	Get the eventKey
     *
     * @return the eventKey
     */
    public String getEventKey() {
        return eventKey;
    }

    /**
     *
     *	Set the eventKey
     *
     * @param eventKey the eventKey to set
     */
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
