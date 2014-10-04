package com.tojaoomy.jupiter.common.entity.customer;

import java.util.List;


/**
 * 客服文本消息
 * 
 * @author hejian
 *
 */
public class CustomNewsMessage extends BaseCustomMessage{
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public CustomMessageType getMsgtype() {
		return CustomMessageType.news;
	}

	class News{
		private List<Article> articles;

		public List<Article> getArticles() {
			return articles;
		}

		public void setArticles(List<Article> articles) {
			this.articles = articles;
		}

	}
	
	class Article{
		private String title;
		private String description;
		private String url;
		private String picurl;

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

		public String getPicurl() {
			return picurl;
		}

		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}
	}
	
}
