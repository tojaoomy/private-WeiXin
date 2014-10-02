package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 * 图片消息 
 *  
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class MusicMessageReponse extends BaseMessageResponse {  
    // 图片
    @XStreamAlias("Music")
    private Music music;

    /**
     *
     *	Get the music
     *
     * @return the music
     */
    public Music getMusic() {
        return music;
    }

    /**
     *
     *	Set the music
     *
     * @param music the music to set
     */
    public void setMusic(Music music) {
        this.music = music;
    }

}
