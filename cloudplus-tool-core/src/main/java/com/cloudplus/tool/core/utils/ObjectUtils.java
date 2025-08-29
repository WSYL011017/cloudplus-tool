package com.cloudplus.tool.core.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 对象操作工具类
 */
public final class ObjectUtils {
    private ObjectUtils() {}

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;

        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).isEmpty();
        } else if (obj instanceof Collection) {
            return ((Collection<?>) obj).isEmpty();
        } else if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        } else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }

        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static <T> T defaultIfNull(T object, T defaultValue) {
        return object != null ? object : defaultValue;
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
        return obj;
    }

    public static boolean equals(Object object1, Object object2) {
        if (object1 == object2) return true;
        if (object1 == null || object2 == null) return false;
        return object1.equals(object2);
    }

    public static int hashCode(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    public static String toString(Object obj) {
        return toString(obj, null);
    }

    public static String toString(Object obj, String defaultValue) {
        return obj == null ? defaultValue : obj.toString();
    }
}
