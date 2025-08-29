package com.cloudplus.tool.core.exception;

/**
 * 工具类异常
 */
public class ToolException extends RuntimeException {
    public ToolException(String message) {
        super(message);
    }

    public ToolException(String message, Throwable cause) {
        super(message, cause);
    }
}
