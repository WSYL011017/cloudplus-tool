package com.cloudplus.tool.core.model;

import com.cloudplus.tool.core.constant.enums.ResultCode;

import java.io.Serializable;
import java.time.Instant;

/**
 * 统一API响应结果封装
 */
public record R<T extends Serializable>(int code, String message, T data, Instant timestamp) implements Serializable {

    public static <T extends Serializable> R<T> success() {
        return success(null);
    }

    public static <T extends Serializable> R<T> success(T data) {
        return new R<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data, Instant.now());
    }

    public static <T extends Serializable> R<T> failed() {
        return failed(ResultCode.FAILED.getMessage());
    }

    public static <T extends Serializable> R<T> failed(String message) {
        return failed(ResultCode.FAILED.getCode(), message);
    }

    public static <T extends Serializable> R<T> failed(int code, String message) {
        return new R<>(code, message, null, Instant.now());
    }

    public static <T extends Serializable> R<T> failed(ResultCode resultCode) {
        return new R<>(resultCode.getCode(), resultCode.getMessage(), null, Instant.now());
    }

    public boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.getCode();
    }
}
