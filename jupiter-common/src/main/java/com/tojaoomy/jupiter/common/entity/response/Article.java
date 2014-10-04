package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 文本消息
 * 
 * @author hejian
 * 
 */
@XStreamAlias("item")
public class Article {
    /** 图文消息标题 */
    @XStreamAlias("Title")
    private String title;
    /** 图文消息描述 */
    @XStreamAlias("Description")
    private String description;
    /** 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200 */
    @XStreamAlias("PicUrl")
    private String picUrl;
    /** 点击图文消息跳转链接 */
    @XStreamAlias("Url")
    private String url;

    /**
     * 
     * Get the title
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * Set the title
     * 
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * Get the description
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * Set the description
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * Get the picUrl
     * 
     * @return the picUrl
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 
     * Set the picUrl
     * 
     * @param picUrl
     *            the picUrl to set
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * 
     * Get the url
     * 
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * Set the url
     * 
     * @param url
     *            the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
