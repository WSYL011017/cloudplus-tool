package com.cloudplus.tool.core.utils;

import com.cloudplus.tool.core.constant.ToolConstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 核心工具类
 */
public final class CoreUtils {
    private CoreUtils() {}

    /**
     * 生成UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成跟踪ID
     */
    public static String generateTraceId() {
        return "trace_" + System.currentTimeMillis() + "_" + generateUUID().substring(0, 8);
    }

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * 判断字符串是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 格式化日期时间
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        return formatDateTime(dateTime, ToolConstants.DATETIME_FORMAT);
    }

    /**
     * 格式化日期时间
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null) return "";
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }

    /**
     * 验证邮箱格式
     */
    public static boolean isEmail(String email) {
        if (isEmpty(email)) return false;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    /**
     * 验证手机号格式
     */
    public static boolean isPhone(String phone) {
        if (isEmpty(phone)) return false;
        String regex = "^1[3-9]\\d{9}$";
        return Pattern.compile(regex).matcher(phone).matches();
    }

    /**
     * 驼峰转下划线
     */
    public static String camelToUnderline(String str) {
        if (isEmpty(str)) return str;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     */
    public static String underlineToCamel(String str) {
        if (isEmpty(str)) return str;

        StringBuilder sb = new StringBuilder();
        boolean toUpper = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '_') {
                toUpper = true;
            } else {
                if (toUpper) {
                    sb.append(Character.toUpperCase(c));
                    toUpper = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 对象转字符串
     */
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * 字符串转整数
     */
    public static Integer toInt(String str, Integer defaultValue) {
        if (isEmpty(str)) return defaultValue;
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 字符串转长整数
     */
    public static Long toLong(String str, Long defaultValue) {
        if (isEmpty(str)) return defaultValue;
        try {
            return Long.parseLong(str.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 字符串转布尔值
     */
    public static Boolean toBoolean(String str, Boolean defaultValue) {
        if (isEmpty(str)) return defaultValue;
        String value = str.trim().toLowerCase();
        return "true".equals(value) || "1".equals(value) || "yes".equals(value);
    }
}