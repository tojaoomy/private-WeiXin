package com.tojaoomy.jupiter.common.entity.menu;

import com.tojaoomy.jupiter.common.enumeration.ButtonType;


/**
 * View类型的按钮
 * 
 * @author hejian
 *
 *  @date 2014年9月21日
 */
public class ViewButton extends Button {
    /** 菜单的响应动作类型 */
    private String type = ButtonType.VIEW.code();

    /** 网页链接，用户点击菜单可打开链接，不超过256字节 */
    private String url;

    /**
     *
     *	Get the type
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     *
     *	Set the type
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     *	Get the url
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     *	Set the url
     *
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
