package com.tojaoomy.jupiter.common.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 * 图片消息 
 *  
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class ImageMessageRequest extends BaseMessageRequest {  
    // 图片链接  
    @XStreamAlias("PicUrl")
    private String picUrl;  
       
    public String getPicUrl() {  
        return picUrl;  
    }  
       
    public void setPicUrl(String picUrl) {  
        this.picUrl = picUrl;  
    }  
}
