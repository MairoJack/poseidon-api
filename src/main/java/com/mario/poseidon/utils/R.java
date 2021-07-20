package com.mario.poseidon.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author mario on 2021/7/19.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Accessors(chain = true)
public class R<T> {

    private int code;
    private String msg;
    private T data;

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return new R<>(200, "成功");
    }

    public static <T> R<T> ok(T data) {
        return new R<>(200, "成功", data);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(300, msg);
    }

    public static <T> R<T> authFail(String msg) {
        return new R<>(401, msg);
    }

}
