package com.mario.poseidon.utils;

import com.mario.poseidon.bean.vo.UserInfoVO;

/**
 * @author mario on 2021/7/20.
 */
public class ContextHolder {
    public static ThreadLocal<UserInfoVO> context = new ThreadLocal<>();

    public static void setUserInfo(UserInfoVO userInfo) {
        context.set(userInfo);
    }

    public static UserInfoVO getUserInfo() {
        return context.get();
    }

    public static void shutdown() {
        context.remove();
    }
}
