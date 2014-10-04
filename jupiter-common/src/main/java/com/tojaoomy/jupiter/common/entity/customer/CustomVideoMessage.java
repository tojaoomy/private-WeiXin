package com.tojaoomy.jupiter.common.entity.customer;


/**
 * 客服文本消息
 * 
 * @author hejian
 *
 */
public class CustomVideoMessage extends BaseCustomMessage{
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public CustomMessageType getMsgtype() {
		return CustomMessageType.video;
	}

	class Video{
		private String media_id;
		private String thumb_media_id;
		private String title;
		private String description;

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

		public String getThumb_media_id() {
			return thumb_media_id;
		}

		public void setThumb_media_id(String thumb_media_id) {
			this.thumb_media_id = thumb_media_id;
		}

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

	}
	
}
