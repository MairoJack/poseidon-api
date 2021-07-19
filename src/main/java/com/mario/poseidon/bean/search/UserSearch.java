package com.mario.poseidon.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mario.poseidon.bean.entity.User;
import com.mario.poseidon.common.BaseSearch;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mario on 2021/7/19.
 */
@Getter
@Setter
public class UserSearch implements BaseSearch<User> {

    private String username;

    @Override
    public Wrapper<User> query() {
        return Wrappers
                .<User>lambdaQuery()
                .like(StrUtil.isNotBlank(username), User::getUsername, username)
                .orderByDesc(User::getId)
                ;
    }
}
