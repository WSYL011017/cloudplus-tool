package com.cloudplus.tool.core.utils;

/**
 * 类型转换工具类
 */
public final class ConvertUtils {
    private ConvertUtils() {}

    public static Integer toInt(Object value, Integer defaultValue) {
        if (value == null) return defaultValue;

        try {
            if (value instanceof Number) {
                return ((Number) value).intValue();
            } else if (value instanceof Boolean) {
                return ((Boolean) value) ? 1 : 0;
            } else {
                return Integer.parseInt(value.toString().trim());
            }
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static Long toLong(Object value, Long defaultValue) {
        if (value == null) return defaultValue;

        try {
            if (value instanceof Number) {
                return ((Number) value).longValue();
            } else if (value instanceof Boolean) {
                return ((Boolean) value) ? 1L : 0L;
            } else {
                return Long.parseLong(value.toString().trim());
            }
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static Double toDouble(Object value, Double defaultValue) {
        if (value == null) return defaultValue;

        try {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            } else if (value instanceof Boolean) {
                return ((Boolean) value) ? 1.0 : 0.0;
            } else {
                return Double.parseDouble(value.toString().trim());
            }
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static Boolean toBoolean(Object value, Boolean defaultValue) {
        switch (value) {
            case null -> {
                return defaultValue;
            }
            case Boolean b -> {
                return b;
            }
            case Number number -> {
                return number.intValue() != 0;
            }
            default -> {
                String strValue = value.toString().trim().toLowerCase();
                return "true".equals(strValue) || "1".equals(strValue) || "yes".equals(strValue) || "on".equals(strValue);
            }
        }

    }

    public static String toString(Object value, String defaultValue) {
        if (value == null) return defaultValue;
        return value.toString();
    }
}
