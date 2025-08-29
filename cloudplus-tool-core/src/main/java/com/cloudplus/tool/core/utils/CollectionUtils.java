package com.cloudplus.tool.core.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 集合处理工具类
 */
public final class CollectionUtils {
    private CollectionUtils() {}

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static <T> T getFirst(Collection<T> collection) {
        if (isEmpty(collection)) return null;
        return collection.iterator().next();
    }
}
