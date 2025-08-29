package com.cloudplus.tool.core.exception;

/**
 * 验证异常
 */
public class ValidationException extends BusinessException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}