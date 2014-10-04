package com.tojaoomy.jupiter.common.entity.customer;

/**
 * 客服消息基类
 * 
 * http://mp.weixin.qq.com/wiki/index.php?title=%E5%8F%91%E9%80%81%E5%AE%A2%E6%9C%8D%E6%B6%88%E6%81%AF#.E5.8F.91.E9.80.81.E9.9F.B3.E4.B9.90.E6.B6.88.E6.81.AF
 * 
 * @author hejian
 *
 */
public abstract class BaseCustomMessage {
	private String touser;
	@SuppressWarnings("unused")
	private CustomMessageType msgtype;

	public BaseCustomMessage() {
		setMsgtype(getMsgtype());
	}
	
	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public abstract CustomMessageType getMsgtype();

	public void setMsgtype(CustomMessageType msgtype) {
		this.msgtype = msgtype;
	}
	
	enum CustomMessageType{
		text,image,voice,video,music,news
	}

}
