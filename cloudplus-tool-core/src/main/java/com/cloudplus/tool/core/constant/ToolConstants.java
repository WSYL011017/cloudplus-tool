package com.cloudplus.tool.core.constant;

/**
 * 通用常量定义
 */
public final class ToolConstants {

    private ToolConstants() {
    }

    // 响应状态码
    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE = 500;
    public static final int UNAUTHORIZED_CODE = 401;
    public static final int FORBIDDEN_CODE = 403;
    public static final int NOT_FOUND_CODE = 404;
    public static final int BAD_REQUEST_CODE = 400;

    // 日期格式
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT = "HH:mm:ss";

    // 字符编码
    public static final String UTF8 = "UTF-8";
    public static final String GBK = "GBK";

    // 通用状态
    public static final int STATUS_ENABLE = 1;
    public static final int STATUS_DISABLE = 0;

    // 逻辑删除
    public static final int DELETED = 1;
    public static final int NOT_DELETED = 0;

    // 分页参数
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int DEFAULT_PAGE_NUM = 1;

    // 请求头
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TRACE_ID_HEADER = "X-Trace-Id";

    // 缓存key前缀
    public static final String CACHE_USER_PREFIX = "user:";
    public static final String CACHE_TOKEN_PREFIX = "token:";
    public static final String CACHE_CONFIG_PREFIX = "config:";
//    public static final String CACHE_L
}