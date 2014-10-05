package com.tojaoomy.jupiter.common.util;

import java.util.ResourceBundle;

public class PropertiesUtil {
	private static ResourceBundle bundle = ResourceBundle.getBundle("weixin/config");
	
	public static String getKey(String key){
		return bundle.getString(key);
	}
}
