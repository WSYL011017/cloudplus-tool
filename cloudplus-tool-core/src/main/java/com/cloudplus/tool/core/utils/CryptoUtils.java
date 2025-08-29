package com.cloudplus.tool.core.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 加密解密工具类
 */
public final class CryptoUtils {
    private CryptoUtils() {}

    public static String md5(String input) {
        return hash(input, "MD5");
    }

    public static String sha1(String input) {
        return hash(input, "SHA-1");
    }

    public static String sha256(String input) {
        return hash(input, "SHA-256");
    }

    public static String sha512(String input) {
        return hash(input, "SHA-512");
    }

    private static String hash(String input, String algorithm) {
        if (StringUtils.isBlank(input)) return null;

        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unsupported algorithm: " + algorithm, e);
        }
    }

    public static String base64Encode(String input) {
        if (StringUtils.isBlank(input)) return null;
        return Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64Decode(String input) {
        if (StringUtils.isBlank(input)) return null;
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    public static String base64UrlEncode(String input) {
        if (StringUtils.isBlank(input)) return null;
        return Base64.getUrlEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String base64UrlDecode(String input) {
        if (StringUtils.isBlank(input)) return null;
        byte[] decodedBytes = Base64.getUrlDecoder().decode(input);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
