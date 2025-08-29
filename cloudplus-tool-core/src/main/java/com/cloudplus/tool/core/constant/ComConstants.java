package com.cloudplus.tool.core.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用常量定义
 */
public final class ComConstants {

    private ComConstants() {}

    //登录图形验证码缓存时间，单位：s
    public static final int VERCODE_CACHE_TIME = 60;

    /** yes or no **/
    public static final byte NO = 0;
    public static final byte YES = 1;

    /** 通用 可用 / 禁用 **/
    public static final int PUB_USABLE = 1;
    public static final int PUB_DISABLE = 0;

    public static final Map<Integer, String> PUB_USABLE_MAP = new HashMap<>();
    static {
        PUB_USABLE_MAP.put(PUB_USABLE, "正常");
        PUB_USABLE_MAP.put(PUB_DISABLE, "停用");
    }

    /**
     * 性别 1- 男， 2-女
     */
    public static final byte SEX_UNKNOWN = 0;
    public static final byte SEX_MALE = 1;
    public static final byte SEX_FEMALE = 2;


    public static final long TOKEN_TIME = 60 * 60 * 2; //单位：s,  两小时

    //access_token 名称
    public static final String ACCESS_TOKEN_NAME = "iToken";

    /** ！！不同系统请放置不同的redis库 ！！ **/
    /** 缓存key: 当前用户所有用户的token集合  example: TOKEN_1001_HcNheNDqHzhTIrT0lUXikm7xU5XY4Q */
    public static final String CACHE_KEY_TOKEN = "TOKEN_%s_%s";
    public static String getCacheKeyToken(Long sysUserId, String uuid){
        return String.format(CACHE_KEY_TOKEN, sysUserId, uuid);
    }


    /** 图片验证码 缓存key **/
    public static final String CACHE_KEY_IMG_CODE = "img_code_%s";
    public static String getCacheKeyImgCode(String imgToken){
        return String.format(CACHE_KEY_IMG_CODE, imgToken);
    }

    /** 回调URL的格前缀  */
    public static final String PAY_RETURNURL_FIX_ONLY_JUMP_PREFIX = "ONLYJUMP_";

    /** 登录认证类型 **/
    public interface AUTH_TYPE{

        byte LOGIN_USER_NAME = 1; //登录用户名
        byte TELPHONE = 2; //手机号
        byte EMAIL = 3; //邮箱

        byte WX_UNION_ID = 10; //微信unionId
        byte WX_MINI = 11; //微信小程序
        byte WX_MP = 12; //微信公众号

        byte QQ = 20; //QQ
    }


    //菜单类型
    public interface ENT_TYPE{

        String MENU_LEFT = "ML";  //左侧显示菜单
        String MENU_OTHER = "MO";  //其他菜单
        String PAGE_OR_BTN = "PB";  //页面 or 按钮

    }

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
    public static final String CACHE_LOCK_PREFIX = "lock:";
}
