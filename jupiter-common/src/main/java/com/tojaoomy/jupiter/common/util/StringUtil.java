package com.tojaoomy.jupiter.common.util;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * String工具类<br>
 * .
 * 
 * @author chenliang
 */
public class StringUtil {
    /** 字符16进制后数字的长度. */
    public static final int LENGTH_CHAR_HEX = 4;
    
    /** 字符汉字字计数伪长度. */
    public static final int LENGTH_CHINESE_BYTE = 2;
    
    /** 字符"…"的长度. */
    public static final int LENGTH_OMIT = 2;
    
    /**
     * 计算字符串的伪字节长度(字母数字计1，汉字及标点计2)</br>.
     * 
     * @param string 字符串
     * @return 伪字节长度
     */
    public static int byteLength(String string) {
        int count = NumberUtils.INTEGER_ZERO;
        // 遍历每个字符
        for (int i = 0; i < string.length(); i++) {
            // 判断是字符的字节长度，字母数字计1，汉字及标点计2
            if (Integer.toHexString(string.charAt(i)).length() == LENGTH_CHAR_HEX) {
                count += LENGTH_CHINESE_BYTE;
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * 按指定长度，省略字符串部分字符.<br /></br>
     * 例如: <code>omitString(string,30)</code><br /><br />
     * 对于字符串"中文字符串,中文字符串,中文字符串,中文字符串,中文字符串,中文字符串,中文字符串"<br />
     * output "中文字符串,中文字符串,中文字…"<br />
     * <br />
     * 对于字符串"english string english string,english string,english string,english string"<br />
     * output "english string,english strin…"<br />
     * <br />
     * 对于字符串"中文 and english,english and 中文,中文 and english,"<br />
     * output "中文 and english,english and…"<br>
     * <br />
     * 
     * 被截取后的字符串,在页面上显示出来的效果是长度相同</br>
     * <font color="red">注：对于微软雅黑这类不等宽字体则输出长度会有出入</font>
     * 
     * @param string String intercepted 被截取的字符串
     * @param length Intercept length 截取长度
     * @return String after interception 截取后的字符串
     */
    public static String omitString(String string, int length) {
        StringBuilder sb = new StringBuilder();
        // 判断是否需要截取
        if (byteLength(string) > length) {
            int count = NumberUtils.INTEGER_ZERO;
            // 遍历每个字符
            for (int i = 0; i < string.length(); i++) {
                char temp = string.charAt(i);
                // 判断是字符的字节长度，字母数字计1，汉字及标点计2
                if (Integer.toHexString(temp).length() == LENGTH_CHAR_HEX) {
                    count += LENGTH_CHINESE_BYTE;
                } else {
                    count++;
                }
                
                // 判断当前截取字符长度
                if (count < length - LENGTH_OMIT) {
                    sb.append(temp);
                } else if (count == length - LENGTH_OMIT) {
                    sb.append(temp);
                    break;
                } else if (count > length - LENGTH_OMIT) {
                    sb.append(StringUtils.EMPTY);
                    break;
                }
            }
            sb.append("…");
        } else {
            sb.append(string);
        }
        return sb.toString();
    }
}
