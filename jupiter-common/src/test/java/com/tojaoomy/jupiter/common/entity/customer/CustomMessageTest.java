package com.tojaoomy.jupiter.common.entity.customer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.meidusa.fastjson.JSONObject;
import com.tojaoomy.jupiter.common.entity.customer.CustomImageMessage.Image;
import com.tojaoomy.jupiter.common.entity.customer.CustomMusicMessage.Music;
import com.tojaoomy.jupiter.common.entity.customer.CustomNewsMessage.Article;
import com.tojaoomy.jupiter.common.entity.customer.CustomNewsMessage.News;
import com.tojaoomy.jupiter.common.entity.customer.CustomTextMessage.Content;
import com.tojaoomy.jupiter.common.entity.customer.CustomVideoMessage.Video;
import com.tojaoomy.jupiter.common.entity.customer.CustomVoiceMessage.Voice;

public class CustomMessageTest {
	@Test
	public void testCustomTextMessage() {
		CustomTextMessage customTextMessage = new CustomTextMessage();
		customTextMessage.setTouser("aaa");
		Content content = customTextMessage.new Content();
		content.setContent("hello");
		customTextMessage.setText(content);
		System.out.println(JSONObject.toJSONString(customTextMessage));
	}
	
	@Test
	public void testCustomImageMessage() {
		CustomImageMessage message = new CustomImageMessage();
		message.setTouser("OPENID");
		Image image = message.new Image();
		image.setMedia_id("MEDIA_ID");
		message.setImage(image);
		System.out.println(JSONObject.toJSONString(message));
	}
	
	@Test
	public void testCustomVoiceMessage() {
		CustomVoiceMessage message = new CustomVoiceMessage();
		message.setTouser("OPENID");
		Voice voice = message.new Voice();
		voice.setMedia_id("MEDIA_ID");
		message.setVoice(voice);
		System.out.println(JSONObject.toJSONString(message));
	}
	
	@Test
	public void testCustomVideoMessage() {
		CustomVideoMessage message = new CustomVideoMessage();
		message.setTouser("OPENID");
		Video video= message.new Video();
		video.setMedia_id("MEDIA_ID");
		video.setThumb_media_id("THUMB_MEDIA_ID");
		message.setVideo(video);
		System.out.println(JSONObject.toJSONString(message));
	}
	
	@Test
	public void testCustomMusicMessage() {
		CustomMusicMessage message = new CustomMusicMessage();
		message.setTouser("OPENID");
		Music music= message.new Music();
		music.setTitle("MUSIC_TITLE");
		music.setDescription("MUSIC_DESCRIPTION");
		music.setMusicurl("MUSIC_URL");
		music.setHqmusicurl("HQ_MUSIC_URL");
		music.setThumb_media_id("THUMB_MEDIA_ID");
		message.setMusic(music);
		System.out.println(JSONObject.toJSONString(message));
	}
	
	@Test
	public void testCustomNewsMessage() {
		CustomNewsMessage message = new CustomNewsMessage();
		message.setTouser("OPENID");
		News news= message.new News();
		List<Article> articles = new ArrayList<Article>();
		Article article = message.new Article();
		article.setTitle("Happy Day");
		article.setPicurl("picurl");
		article.setUrl("url");
		article.setDescription("description");
		articles.add(article);
		articles.add(article);
		news.setArticles(articles);
		message.setNews(news);
		System.out.println(JSONObject.toJSONString(message));
	}
}
