package com.tojaoomy.jupiter.common.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 * 图片消息 
 *  
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class ImageMessageReponse extends BaseMessageResponse {  
    // 图片
    @XStreamAlias("Image")
    private Image image;

    /**
     *
     *	Get the image
     *
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     *	Set the image
     *
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    } 
       
}
