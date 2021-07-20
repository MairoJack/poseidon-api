package com.mario.poseidon.exception;

/**
 * 认证异常
 */
public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException(String msg) {
        super(msg);
    }
}
