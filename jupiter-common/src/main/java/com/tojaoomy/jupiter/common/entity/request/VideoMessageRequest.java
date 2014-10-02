/**
 *
 * Copyright (C), 2013-2013, 上海汽车集团股份有限公司
 * FileName : ViedoMessage.java
 * Author : 何剑
 * Date : 2014年9月19日
 * 
 */
package com.tojaoomy.jupiter.common.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class VideoMessageRequest extends BaseMessageRequest {
    // 视频消息媒体ID
    @XStreamAlias("MediaId")
    private String mediaId;
    
    //视频消息缩略图的媒体ID
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    /**
     *
     *	Get the mediaId
     *
     * @return the mediaId
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     *
     *	Set the mediaId
     *
     * @param mediaId the mediaId to set
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     *
     *	Get the thumbMediaId
     *
     * @return the thumbMediaId
     */
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    /**
     *
     *	Set the thumbMediaId
     *
     * @param thumbMediaId the thumbMediaId to set
     */
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
