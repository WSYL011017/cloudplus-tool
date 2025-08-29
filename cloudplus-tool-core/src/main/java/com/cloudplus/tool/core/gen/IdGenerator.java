package com.cloudplus.tool.core.gen;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ID生成工具类
 */
public final class IdGenerator {
    private IdGenerator() {}

    private static final AtomicLong ATOMIC_LONG = new AtomicLong(0);
    private static final String BASE62_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * 生成UUID（无连字符）
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成短UUID（8位）
     */
    public static String shortUuid() {
        return uuid().substring(0, 8);
    }

    /**
     * 生成雪花ID（简化版）
     */
    public static long snowflakeId() {
        long timestamp = System.currentTimeMillis();
        long sequence = ATOMIC_LONG.incrementAndGet() & 0xFFF; // 12位序列号
        return (timestamp << 12) | sequence;
    }

    /**
     * 生成递增ID
     */
    public static long incrementId() {
        return ATOMIC_LONG.incrementAndGet();
    }

    /**
     * 生成随机数字字符串
     */
    public static String randomNumeric(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    /**
     * 生成随机字符串（字母数字）
     */
    public static String randomAlphanumeric(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * BASE62_CHARS.length());
            sb.append(BASE62_CHARS.charAt(index));
        }
        return sb.toString();
    }
}
