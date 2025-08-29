package com.cloudplus.tool.core.utils;

import java.util.regex.Pattern;

/**
 * 验证工具类
 */
public final class ValidateUtils {
    private ValidateUtils() {}

    // 邮箱正则
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    // 手机号正则
    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";
    // 身份证正则
    private static final String ID_CARD_REGEX = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
    // URL正则
    private static final String URL_REGEX = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$";

    public static boolean isEmail(String email) {
        return isMatch(EMAIL_REGEX, email);
    }

    public static boolean isPhone(String phone) {
        return isMatch(PHONE_REGEX, phone);
    }

    public static boolean isIdCard(String idCard) {
        return isMatch(ID_CARD_REGEX, idCard);
    }

    public static boolean isUrl(String url) {
        return isMatch(URL_REGEX, url);
    }

    public static boolean isMatch(String regex, String input) {
        if (StringUtils.isBlank(input)) return false;
        return Pattern.compile(regex).matcher(input).matches();
    }

    public static boolean isNumber(String str) {
        if (StringUtils.isBlank(str)) return false;
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String str) {
        if (StringUtils.isBlank(str)) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLong(String str) {
        if (StringUtils.isBlank(str)) return false;
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
