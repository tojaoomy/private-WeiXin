package com.tojaoomy.jupiter.common.entity.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/** 扫描信息 */
public class ScanCodeInfo{
	/** 扫描类型，一般是qrcode */
	@XStreamAlias("ScanType")
	private String ScanType;
	
	/** 扫描结果，即二维码对应的字符串信息 */
	@XStreamAlias("ScanResult")
	private String ScanResult;

	public String getScanType() {
		return ScanType;
	}

	public void setScanType(String scanType) {
		ScanType = scanType;
	}

	public String getScanResult() {
		return ScanResult;
	}

	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}
	
}