package com.czq.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * JDK8相关时间处理工具类。
 * <p>
 * 注：基础公共类，请保证使用上的安全性！严禁封装存在安全漏洞或存在使用安全问题，却不在文档注释上标明的工具方法。
 *
 * @author leonzhangxf 20190319
 * @see LocalDateTime
 */
public class LocalDateTimeUtils {

    /**
     * 将 {@see java.util.Date} 转换为 {@see java.time.LocalDateTime}。
     * 使用默认时区。
     *
     * @param date JDK8之前的时间格式 {@see java.util.Date}
     * @return {@see java.time.LocalDateTime}
     */
    public static LocalDateTime ofDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 使用自定义时间格式化字符，格式化时间
     *
     * @param date    JDK8之前的时间格式 {@see java.util.Date}
     * @param pattern 时间格式化字符串，参见 {@see java.time.format.DateTimeFormatter}
     * @return 格式化后的字符串
     */
    public static String format(Date date, String pattern) {
        return ofDate(date).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将指定格式的字符转换为时间
     * 一般只能转换精确到时间格式，如yyyy-MM-dd HH:mm:ss
     *
     * @param value   字符
     * @param pattern 指定格式
     * @return 转换后的时间
     */
    public static Date parse(String value, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 将指定格式的字符转换为时间
     *
     * @param value   字符
     * @param pattern 指定格式
     * @return 转换后的时间
     */
    public static Date parseDate(String value, String pattern) {
        LocalDate localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * 使用自定义时间格式化字符，格式化时间
     *
     * @param localDateTime {@see java.time.LocalDateTime}
     * @param pattern       时间格式化字符串，参见 {@see java.time.format.DateTimeFormatter}
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 使用时间格式化类库，格式化时间
     *
     * @param localDateTime     {@see java.time.LocalDateTime}
     * @param dateTimeFormatter JDK8后提供的时间格式化类库 {@see java.time.format.DateTimeFormatter}，
     *                          用于替代 {@see java.text.SimpleDateFormat}.
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime.format(dateTimeFormatter);
    }

    public static void main(String[] args) {
        String format = LocalDateTimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(format);
        Date parse = LocalDateTimeUtils.parse(format, "yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTimeUtils.format(parse, "yyyy-MM-dd HH:mm:ss"));

        System.out.println("===========");
        Date date = LocalDateTimeUtils.parseDate("2019-06-13", "yyyy-MM-dd");
        System.out.println(LocalDateTimeUtils.format(date, "yyyy-MM-dd"));
    }
}
