package com.tojaoomy.jupiter.common.entity.customer;


/**
 * 客服文本消息
 * 
 * @author hejian
 *
 */
public class CustomTextMessage extends BaseCustomMessage{
	private Content text;
	
	public Content getText() {
		return text;
	}

	public void setText(Content text) {
		this.text = text;
	}
	
	@Override
	public CustomMessageType getMsgtype() {
		return CustomMessageType.text;
	}

	class Content{
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}
	
}
