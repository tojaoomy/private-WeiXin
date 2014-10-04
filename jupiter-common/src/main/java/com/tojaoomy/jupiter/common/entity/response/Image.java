package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图片model
 * 
 * @author hejian
 * 
 * @see http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E8%A2%AB%E5%8A%A8%E5%93%8D%E5%BA%94%E6%B6%88%E6%81%AF#.E5.9B.9E.E5.A4.8D.E5.9B.BE.E7.89.87.E6.B6.88.E6.81.AF
 *
 */
public class Image {
    /** 通过上传多媒体文件，得到的id */
    @XStreamAlias("MediaId")
    private String mediaId;

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
}
