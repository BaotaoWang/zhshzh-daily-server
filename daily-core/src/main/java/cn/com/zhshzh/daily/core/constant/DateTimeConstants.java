package cn.com.zhshzh.daily.core.constant;

import java.time.format.DateTimeFormatter;

/**
 * 日期时间相关常量类
 *
 * @author wangbt
 * @since 2022-01-01
 */
public class DateTimeConstants {
    public static final String LOCAL_DATE = "yyyy-MM-dd";
    public static final String LOCAL_TIME = "HH:mm:ss";
    public static final String LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE);
    public static final DateTimeFormatter LOCAL_TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_TIME);
    public static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME);
}
