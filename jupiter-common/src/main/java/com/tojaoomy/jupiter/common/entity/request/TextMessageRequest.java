package com.tojaoomy.jupiter.common.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 * 文本消息 
 *  
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class TextMessageRequest extends BaseMessageRequest {  
    // 消息内容  
    @XStreamAlias("Content")
    private String content;  
       
    public String getContent() {  
        return content;  
    }  
       
    public void setContent(String content) {  
        this.content = content;  
    }  
}
