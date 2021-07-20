package com.mario.poseidon.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import com.mario.poseidon.bean.vo.UserInfoVO;
import com.mario.poseidon.common.Constants;
import com.mario.poseidon.exception.UnAuthorizedException;
import com.mario.poseidon.utils.ContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author mario on 2021/7/20.
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authorization = request.getHeader(Constants.HEADER_AUTH);
        if (StrUtil.isEmpty(authorization) || !StrUtil.startWith(authorization, Constants.Bearer)) {
            throw new UnAuthorizedException("非法令牌");
        }

        JWT jwt = JWT
                .of(authorization.substring(Constants.Bearer.length()))
                .setKey(Constants.JWT_SIGN.getBytes());
        if (!jwt.validate(0)) {
            throw new UnAuthorizedException("无效令牌");
        }
        Integer userId = (Integer) jwt.getPayload(Constants.USER_ID);
        String username = (String) jwt.getPayload(Constants.USERNAME);
        ContextHolder.setUserInfo(new UserInfoVO(userId, username));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ContextHolder.shutdown();
    }
}
