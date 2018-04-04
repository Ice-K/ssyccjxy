package com.ssyccjxy.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description：StringUtils扩展类
 * Cteated by wangpeng
 * 2018/3/31 17:36
 */
public class StringUtil extends org.apache.commons.lang3.StringUtils {

    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 将当前时间转换为精确到秒的字符串，格式为“yyyy-MM-dd HH:mm:ss”
     * @return 精确到秒的时间字符串
     */
    public static String currentTimeAsString() {
        return timeFormat.format(new Date());
    }

    /**
     * 将当前时间转换为精确到日的字符串，格式为“yyyy-MM-dd”
     * @return 精确到日的时间字符串
     */
    public static String currentDateAsString() {
        return dateFormat.format(new Date());
    }

    public static String customTimeAsString(String timeStr) {
        String str;
        try {
            SimpleDateFormat format = new SimpleDateFormat(timeStr);
            str = format.format(new Date());
        } catch(IllegalArgumentException e) {
           logger.error("时间字符串格式不正确");
           throw new RuntimeException("时间字符串格式不正确");
        }
        return str;
    }

}
