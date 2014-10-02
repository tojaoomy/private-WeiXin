package com.tojaoomy.jupiter.common.entity.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 * 链接消息 
 *  
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class LinkMessageRequest extends BaseMessageRequest {  
    // 消息标题  
    @XStreamAlias("Title")
    private String title;  
    // 消息描述  
    @XStreamAlias("Description")
    private String description;  
    // 消息链接  
    @XStreamAlias("Url")
    private String url;  
       
    public String getTitle() {  
        return title;  
    }  
       
    public void setTitle(String title) {  
        this.title = title;  
    }  
       
    public String getDescription() {  
        return description;  
    }  
       
    public void setDescription(String description) {  
        this.description = description;  
    }  
       
    public String getUrl() {  
        return url;  
    }  
       
    public void setUrl(String url) {  
        this.url = url;  
    }  
}