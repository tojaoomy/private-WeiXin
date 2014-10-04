package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @author hejian
 *
 * @see http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E8%A2%AB%E5%8A%A8%E5%93%8D%E5%BA%94%E6%B6%88%E6%81%AF#.E5.9B.9E.E5.A4.8D.E5.9B.BE.E7.89.87.E6.B6.88.E6.81.AF
 *
 */
public class Music {

    /** 音乐标题 */
    @XStreamAlias("Title")
    private String title;
    
    /** 音乐描述 */
    @XStreamAlias("Description")
    private String description;
    
    /** 音乐链接 */
    @XStreamAlias("MusicURL")
    private String musicURL;
    
    /** 高质量音乐链接，WIFI环境优先使用该链接播放音乐 */
    @XStreamAlias("HQMusicUrl")
    private String hQMusicUrl;
    
    /** 缩略图的媒体id，通过上传多媒体文件，得到的id */
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;

    /**
     *
     *	Get the title
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     *	Set the title
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     *	Get the description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     *	Set the description
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     *	Get the musicURL
     *
     * @return the musicURL
     */
    public String getMusicURL() {
        return musicURL;
    }

    /**
     *
     *	Set the musicURL
     *
     * @param musicURL the musicURL to set
     */
    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    /**
     *
     *	Get the hQMusicUrl
     *
     * @return the hQMusicUrl
     */
    public String getHQMusicUrl() {
        return hQMusicUrl;
    }

    /**
     *
     *	Set the hQMusicUrl
     *
     * @param hQMusicUrl the hQMusicUrl to set
     */
    public void setHQMusicUrl(String hQMusicUrl) {
        this.hQMusicUrl = hQMusicUrl;
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
