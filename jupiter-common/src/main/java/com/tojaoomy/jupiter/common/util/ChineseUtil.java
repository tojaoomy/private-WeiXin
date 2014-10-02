package com.tojaoomy.jupiter.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


/**
 * 中文字操作类<br>
 * .
 * 
 * @author
 */
public class ChineseUtil {
    
    /**
     * 功能描述: 返回中文字个数<br>
     * .
     * 
     * @param chinese the chinese
     * @return the int
     */
    public static int countChinese(String chinese) {
        if (StringUtils.isBlank(chinese)) {
            return NumberUtils.INTEGER_ZERO;
        }
        int count = NumberUtils.INTEGER_ZERO;
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(chinese);
        while (m.find()) {
                count++;
        }
        return count;
    }
}
