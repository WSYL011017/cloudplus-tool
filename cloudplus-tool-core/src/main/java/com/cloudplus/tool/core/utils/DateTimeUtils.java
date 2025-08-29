package com.cloudplus.tool.core.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 日期时间处理工具类
 */
public final class DateTimeUtils {
    private DateTimeUtils() {}

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static String format(LocalDateTime dateTime) {
        return format(dateTime, DATETIME_FORMAT);
    }

    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return null;
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }

    public static String format(LocalDate date) {
        return format(date, DATE_FORMAT);
    }

    public static String format(LocalDate date, String pattern) {
        if (date == null) return null;
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return parseDateTime(dateTimeStr, DATETIME_FORMAT);
    }

    public static LocalDateTime parseDateTime(String dateTimeStr, String pattern) {
        if (StringUtils.isBlank(dateTimeStr)) return null;
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseDate(String dateStr) {
        return parseDate(dateStr, DATE_FORMAT);
    }

    public static LocalDate parseDate(String dateStr, String pattern) {
        if (StringUtils.isBlank(dateStr)) return null;
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static boolean isAfter(LocalDateTime date1, LocalDateTime date2) {
        return date1.isAfter(date2);
    }

    public static boolean isBefore(LocalDateTime date1, LocalDateTime date2) {
        return date1.isBefore(date2);
    }

    public static long between(LocalDateTime start, LocalDateTime end, ChronoUnit unit) {
        return unit.between(start, end);
    }

    public static LocalDateTime plusDays(LocalDateTime dateTime, long days) {
        return dateTime.plusDays(days);
    }

    public static LocalDateTime minusDays(LocalDateTime dateTime, long days) {
        return dateTime.minusDays(days);
    }
}
