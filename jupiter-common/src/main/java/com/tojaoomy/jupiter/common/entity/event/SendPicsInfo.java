package com.tojaoomy.jupiter.common.entity.event;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/** 发送的图片信息 */
public class SendPicsInfo {
	/** 发送的图片数量 */
	@XStreamAlias("Count")
	private Long count;
	
	/** 图片列表  */
	@XStreamAlias("PicList")
	private List<Picture> picList;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<Picture> getPicList() {
		return picList;
	}

	public void setPicList(List<Picture> picList) {
		this.picList = picList;
	}
}