package com.mario.poseidon.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.jwt.JWT;
import com.mario.poseidon.common.Constants;

import java.util.Date;

/**
 * 全局工具
 *
 * @author mario on 2021/7/20.
 */
public class G {

    /**
     * sha256加密
     */
    public static String sha256(String password) {
        return new Digester(DigestAlgorithm.SHA256).digestHex(password);

    }

    /**
     * 生产jwt
     */
    public static String jwt(Integer userId, String username) {
        return JWT
                .create()
                .setPayload(Constants.USER_ID, userId)
                .setPayload(Constants.USERNAME, username)
                .setKey(Constants.JWT_SIGN.getBytes())
                .setExpiresAt(DateUtil.offsetSecond(new Date(), Constants.TOKEN_EXPIRE_TIME))
                .sign();
    }
}
