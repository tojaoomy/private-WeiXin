package com.tojaoomy.jupiter.common.entity.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/** 
 * 发送的位置信息
 */
public class SendLocationInfo {
	/** 纬度坐标信息 */
	@XStreamAlias("Location_X")
	private String location_X;
	
	/** 经度坐标信息 */
	@XStreamAlias("Location_Y")
	private String location_Y;
	
	/** 精度，可理解为精度或者比例尺、越精细的话 scale越高  */
	@XStreamAlias("Scale")
	private String scale;
	
	/** 地理位置的字符串信息  */
	@XStreamAlias("Label")
	private String label;
	
	/** 朋友圈POI的名字，可能为空  */
	@XStreamAlias("Poiname")
	private String poiname;

	public String getLocation_X() {
		return location_X;
	}

	public void setLocation_X(String location_X) {
		this.location_X = location_X;
	}

	public String getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(String location_Y) {
		this.location_Y = location_Y;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPoiname() {
		return poiname;
	}

	public void setPoiname(String poiname) {
		this.poiname = poiname;
	}
}
