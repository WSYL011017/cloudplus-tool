package com.cloudplus.tool.core.utils;

import java.util.Objects;

/**
 * 字符串处理工具类
 */
public final class StringUtils {
    private StringUtils() {}

    public static boolean isEmpty(CharSequence str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(CharSequence str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(CharSequence str) {
        if (isEmpty(str)) return true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence str) {
        return !isBlank(str);
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trimToNull(String str) {
        String result = trim(str);
        return isEmpty(result) ? null : result;
    }

    public static boolean equals(String str1, String str2) {
        return Objects.equals(str1, str2);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }

    public static String capitalize(String str) {
        if (isEmpty(str)) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String uncapitalize(String str) {
        if (isEmpty(str)) return str;
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

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

    public static String underlineToCamel(String str) {
        return underlineToCamel(str, false);
    }

    public static String underlineToCamel(String str, boolean firstLetterUpperCase) {
        if (isEmpty(str)) return str;

        StringBuilder sb = new StringBuilder();
        boolean toUpper = firstLetterUpperCase;
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
}
