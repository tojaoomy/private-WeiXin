package com.tojaoomy.jupiter.common.entity.customer;


/**
 * 客服文本消息
 * 
 * @author hejian
 *
 */
public class CustomVoiceMessage extends BaseCustomMessage{
	private Voice voice;
	
	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	@Override
	public CustomMessageType getMsgtype() {
		return CustomMessageType.voice;
	}

	class Voice{
		private String media_id;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

	}
	
}
