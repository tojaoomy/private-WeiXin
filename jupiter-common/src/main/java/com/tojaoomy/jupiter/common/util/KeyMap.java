package com.tojaoomy.jupiter.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hejian
 *
 *  @date 2014年9月21日
 */
public class KeyMap {
    
    public static Map<String,String> keyMap = new HashMap<String, String>();
    
    /** 我的询价 KEY */
    public static final String CUSTOMER_PRICE = "customer_price";
    
    /** 我的订单 KEY */
    public static final String CUSTOMER_ORDER = "customer_order";
    
    /** 我的积分 KEY */
    public static final String CUSTOMER_POINTS = "customer_points";
    
//    /** 我的保养 KEY */
//    public static final String MAINTENANCE = "maintenance";
    
//    /** 车查询 KEY */
//    public static final String CAR_QUERY = "car_query";
    
    /** 在线咨询 KEY */
    public static final String SERVICE_ONLINE = "service_online";
    
    /** 客服电话 KEY */
    public static final String SERVICE_PHONE = "service_phone";
    
    static{
        keyMap.put(CUSTOMER_PRICE, CUSTOMER_PRICE);
        keyMap.put(CUSTOMER_ORDER, CUSTOMER_ORDER);
        keyMap.put(CUSTOMER_POINTS, CUSTOMER_POINTS);
        keyMap.put(SERVICE_ONLINE, SERVICE_ONLINE);
        keyMap.put(SERVICE_PHONE, SERVICE_PHONE);
    }
}
