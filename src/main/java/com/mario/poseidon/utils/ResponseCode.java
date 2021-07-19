package com.mario.poseidon.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mario on 2021/7/19.
 */
public enum ResponseCode {

    SUCCESS(2000, "成功"),
    FAIL(4000, "失败"),
    UNAUTHORIZED(2002, "认证失败"),
    PERMISSION_DENIED(2003, "权限不足"),
    ACCESS_TOKEN_EXPIRED(2004, "access_token过期"),
    REFRESH_TOKEN_EXPIRED(2005, "refresh_token过期"),
    MEDIA_UPLOAD_FAIL(2007, "上传失败"),
    MEDIA_DELETE_FAIL(2008, "删除失败"),
    MEDIA_NOT_FOUND(2009, "媒体不存在"),
    MEDIA_UPLOAD_LIMIT(2010, "上传限制1~5"),
    REPEAT_SUBMIT(2011, "重复提交"),
    USERNAME_OR_PASSWORD_FAIL(2012, "您的账号不存在或密码不正确");

    @Getter
    private final int code;
    @Getter
    @Setter
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
