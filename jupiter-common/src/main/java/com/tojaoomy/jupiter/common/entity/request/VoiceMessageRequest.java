package com.tojaoomy.jupiter.common.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 音频消息
 * 
 * @author 何剑
 * @date 2014-09-19
 */
@XStreamAlias("xml")
public class VoiceMessageRequest extends BaseMessageRequest {
    // 媒体ID
    @XStreamAlias("MediaId")
    private String mediaId;
    
    // 语音格式
    @XStreamAlias("Format")
    private String format;

    // 语音识别结果，UTF8编码
    @XStreamAlias("Recognition")
    private String recognition;

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
     * Get the format
     * 
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * 
     * Set the format
     * 
     * @param format
     *            the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * 
     * Get the recognition
     * 
     * @return the recognition
     */
    public String getRecognition() {
        return recognition;
    }

    /**
     * 
     * Set the recognition
     * 
     * @param recognition
     *            the recognition to set
     */
    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

}
