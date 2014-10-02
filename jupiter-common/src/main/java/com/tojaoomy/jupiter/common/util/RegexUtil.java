package com.tojaoomy.jupiter.common.util;

import java.util.regex.Pattern;

/**
 * 正则工具类<br>
 * 
 * 此类提供日常开发中常用的正则验证函数，比如：邮箱、手机号、电话号码、<br>
 * 身份证号码、日期、数字、小数、URL、IP地址等。.
 * 
 * @author chenliang
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class RegexUtil {
    
    /** long类型参数的判断. */
    public static final String REGEX_LONG = "\\-?\\d{1,16}";
    /**
     * 验证Email，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     */
    public static final String REGEX_EMAIL = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    /** 验证身份证号码， idCard 居民身份证号码15位或18位，最后一位可能是数字或字母. */
    public static final String REGEX_IDCARD = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港）） 移动、联通、电信运营商的号码段
     * <p>
     * 移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡） 、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）
     * </p>
     * <p>
     * 联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）
     * </p>
     * <p>
     * 电信的号段：133、153、180（未启用）、189
     * </p>
     * <p>
     * 虚拟运营商号段：17
     * </p>
     * 更改为第一位是1， 其它为数字 "(\\+\\d+)?1[34578]\\d{9}$";
     */
    public static final String REGEX_MOBILE = "^1[34578]\\d{9}$";

    /**
     * 验证固定电话号码 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
     * <p>
     * <b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字， 数字之后是空格分隔的国家（地区）代码。
     * </p>
     * <p>
     * <b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号—— 对不使用地区或城市代码的国家（地区），则省略该组件。
     * </p>
     * <p>
     * <b>电话号码：</b>这包含从 0 到 9 的一个或多个数字
     * </p>
     * .
     */
    public static final String REGEX_PHONE = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";

    /** 验证整数（正整数和负整数），digit 一位或多位0-9之间的整数. */
    public static final String REGEX_DIGIT = "\\-?[1-9]\\d+";
    
    /** 验证是否是数字. */
    public static final String REGEX_MEM = "^[0-9]*$";

    /**
     * 验证整数和浮点数（正负整数和正负浮点数）， 一位或多位0-9之间的浮点数，如：1.23，233.30
     */
    public static final String REGEX_DECIMALS = "\\-?[1-9]\\d+(\\.\\d+)?";

    /** 验证空白字符，包括：空格、\t、\n、\r、\f、\x0B. */
    public static final String REGEX_BLANKSPACE = "\\s+";

    /** 验证中文. */
    public static final String REGEX_CHINESE = "^[\u4E00-\u9FA5]+$";

    /**
     * 验证日期（年月日） 日期，格式：1992-09-03，或1992.09.03
     */
    public static final String REGEX_BIRTHDAY = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";

    /**
     * 验证URL地址 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
     */
    public static final String REGEX_URL = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";

    /**
     * 匹配中国邮政编码 "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
     */
    public static final String REGEX_POSTCODE = "^[1-9]\\d{5}";

    /**
     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
     */
    public static final String REGEX_IP = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";

    /** 仅英文正则验证. */
    public static final String REGEX_ENGLISH = "^[A-Za-z]+$";

    /**
     * 传真正则表达式(兼容格式: 国家代码(4到5位)-区号(3到4位)-电话号码(7到8位) //"^(([0]\\d{3,4}-)?(0\\d{2,3})-)?(\\d{7,8})$"; 更改为：数字、加号、减号、左右括号
     * "[0-9\\+\\-\\(\\)]";.
     */
    public static final String REGEX_FAX = "^[\\d\\+\\-\\(\\)]*$";

    /** 非负整数. */
    public static final String REGEX_POSITIVE_NUM = "^\\d+$";

    /** 自然数. */
    public static final String REGEX_NATURE_NUMBER = "^[1-9]\\d*|0$";

    /** 英文、数字、中文. */
    public static final String REGEX_EN_NUM_ZH = "^[\u4E00-\u9FA5a-zA-Z0-9]+$";
    
    /** 英文、数字. */
    public static final String REGEX_EN_NUM = "^[A-Za-z0-9]+$";
    
    /** 数字. */
    public static final String REGEX_NUM = "^[0-9]+$";
    
    /** 英文、数字、中文、点. */
    public static final String REGEX_EN_NUM_ZH_DOT = "^[\\.\u4E00-\u9FA5a-zA-Z0-9]+$";
    
    /** 英文、中文、空格. */
    public static final String REGEX_EN_ZH_BLANK = "^[\\s+\u4E00-\u9FA5a-zA-Z]+$";

    /** 英文、中文. */
    public static final String REGEX_EN_ZH = "^[\u4E00-\u9FA5a-zA-Z]+$";
    
    /** 主战用户名. */
    public static final String REGEX_USERNAME = "^.{6,20}$";
    
    /** 主战密码. */
    public static final String REGEX_PASSWORD = "^.{6,20}$";

    /**
     * 功能描述: 对value进行正则验证<br>
     * .
     * 
     * @param regex 正则表达
     * @param value 待验证的值
     * @return 验证结果
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static boolean check(String regex, String value) {
        if (null == regex || null == value) {
            return false;
        }
        return Pattern.matches(regex, value);
    }
}
