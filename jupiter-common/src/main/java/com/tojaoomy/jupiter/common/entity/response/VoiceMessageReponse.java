package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 *  语音消息
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class VoiceMessageReponse extends BaseMessageResponse {  
       
    /** 语音 */
    @XStreamAlias("Voice")
    private Voice voice;

    /**
     *
     *	Get the voice
     *
     * @return the voice
     */
    public Voice getVoice() {
        return voice;
    }

    /**
     *
     *	Set the voice
     *
     * @param voice the voice to set
     */
    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
