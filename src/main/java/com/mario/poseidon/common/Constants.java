package com.mario.poseidon.common;

public class Constants {

    public static final String HEADER_AUTH = "Authorization";

    public static final String Bearer = "Bearer ";

    public static final Integer TOKEN_EXPIRE_TIME = 60 * 60 * 24 * 7;

    public static final String JWT_SIGN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9";

    public static final String USER_ID = "user_id";

    public static final String USERNAME = "username";

    /**
     * 默认日期时间格式
     */
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 默认日期格式
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 默认时间格式
     */
    public static final String TIME_FORMAT = "HH:mm:ss";
}
