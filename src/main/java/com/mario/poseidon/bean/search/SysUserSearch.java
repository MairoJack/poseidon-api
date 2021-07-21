package com.mario.poseidon.bean.search;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mario.poseidon.bean.entity.SysUser;
import com.mario.poseidon.common.BaseSearch;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mario on 2021/7/19.
 */
@Getter
@Setter
public class SysUserSearch implements BaseSearch<SysUser> {

    private String username;

    @Override
    public Wrapper<SysUser> query() {
        return Wrappers
                .<SysUser>lambdaQuery()
                .like(StrUtil.isNotBlank(username), SysUser::getUsername, username)
                .orderByDesc(SysUser::getId)
                ;
    }
}
