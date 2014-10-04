package com.tojaoomy.jupiter.common.entity.customer;


/**
 * 客服文本消息
 * 
 * @author hejian
 *
 */
public class CustomImageMessage extends BaseCustomMessage{
	private Image image;
	
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public CustomMessageType getMsgtype() {
		return CustomMessageType.image;
	}

	class Image{
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

	}
	
}
