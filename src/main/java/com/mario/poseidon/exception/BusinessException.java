package com.mario.poseidon.exception;

/**
 * 业务异常
 *
 * @author mario on 2021/7/19.
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String msg) {
        super(msg);
    }
}
