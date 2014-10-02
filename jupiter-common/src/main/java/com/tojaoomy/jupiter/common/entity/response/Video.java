/**
 *
 * Copyright (C), 2013-2013, 上海汽车集团股份有限公司
 * FileName : Video.java
 * Author : 何剑
 * Date : 2014年9月19日
 * 
 */
package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 视频 model
 * 
 * @author hejian
 * 
 * @see http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E8%A2%AB%E5%8A%A8%E5%93%8D%E5%BA%94%E6%B6%88%E6%81%AF#.E5.9B.9E.E5.A4.8D.E5.9B.BE.E7.89.87.E6.B6.88.E6.81.AF
 * 
 */
public class Video {
    /** 通过上传多媒体文件，得到的id */
    @XStreamAlias("MediaId")
    private String mediaId;

    /** 缩略图的媒体 ID */
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    /** 视频消息的标题 */
    @XStreamAlias("Title")
    private String title;

    /** 视频消息的描述 */
    @XStreamAlias("Description")
    private String description;

    /**
     * 
     * Get the mediaId
     * 
     * @return the mediaId
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * 
     * Set the mediaId
     * 
     * @param mediaId
     *            the mediaId to set
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * 
     * Get the thumbMediaId
     * 
     * @return the thumbMediaId
     */
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    /**
     * 
     * Set the thumbMediaId
     * 
     * @param thumbMediaId
     *            the thumbMediaId to set
     */
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

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
}
