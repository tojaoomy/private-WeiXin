package com.tojaoomy.jupiter.common.entity.menu;

import com.tojaoomy.jupiter.common.enumeration.ButtonType;


/**
 * Click类型的按钮
 * 
 * @author hejian
 * 
 * @date 2014年9月21日
 */
public class ClickButon extends Button {
    /** 菜单的响应动作类型 */
    private String type = ButtonType.CLICK.code();

    /** 菜单KEY值，用于消息接口推送，不超过128字节 */
    private String key;

    /**
     * 
     * Get the key
     * 
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * 
     * Set the key
     * 
     * @param key
     *            the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * Get the type
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * Set the type
     * 
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

}
