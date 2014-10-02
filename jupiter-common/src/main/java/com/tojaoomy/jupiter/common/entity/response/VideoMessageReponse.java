package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 *  视频消息
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class VideoMessageReponse extends BaseMessageResponse {  
    /** 图文消息个数，限制为10条以内 */
    @XStreamAlias("Video")
    private Video video;

    /**
     *
     *	Get the video
     *
     * @return the video
     */
    public Video getVideo() {
        return video;
    }

    /**
     *
     *	Set the video
     *
     * @param video the video to set
     */
    public void setVideo(Video video) {
        this.video = video;
    }
    
}
