package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 * 文本消息 
 *  
 *      回复的内容不能超过2K，否则微信服务器会放弃响应，用户则收不到回复。
 *      
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class TextMessageReponse extends BaseMessageResponse {  
    // 回复的消息内容  
    @XStreamAlias("Content")
    private String content;  
       
    public String getContent() {  
        return content;  
    }  
       
    public void setContent(String content) {  
        this.content = content;  
    }  
}
