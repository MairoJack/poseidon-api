package com.mario.poseidon.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mario.poseidon.bean.dto.SysUserDTO;
import com.mario.poseidon.bean.entity.SysUser;
import com.mario.poseidon.bean.form.LoginForm;
import com.mario.poseidon.common.BaseService;
import com.mario.poseidon.dao.SysUserDao;
import com.mario.poseidon.exception.BusinessException;
import com.mario.poseidon.utils.G;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends BaseService<SysUserDao, SysUser, SysUserDTO> {

    public SysUserService() {
        super(SysUser.class, "系统用户");
    }

    @Override
    protected void checkExist(SysUser sysUser, SysUserDTO dto) {
        super.isExist(sysUser.getId(), "username", dto.getUsername());
    }

    @Override
    public ICreateExtend<SysUser, SysUserDTO> createExtend() {
        return new ICreateExtend<>() {
            @Override
            public void before(SysUser sysUser, SysUserDTO sysUserDTO) {
                sysUser.setPassword(G.sha256(sysUserDTO.getPassword()));
            }
        };
    }

    @Override
    public IModifyExtend<SysUser, SysUserDTO> modifyExtend() {
        return new IModifyExtend<>() {
            @Override
            public void before(SysUser sysUser, SysUserDTO sysUserDTO) {
                sysUser.setPassword(G.sha256(sysUserDTO.getPassword()));
            }
        };
    }

    /**
     * 登录
     */
    public String login(LoginForm form) {
        SysUser sysUser = super.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, form.getUsername()));
        if (sysUser == null) {
            throw new BusinessException("账号不存在");
        }
        if (!StrUtil.equals(sysUser.getPassword(), G.sha256(form.getPassword()))) {
            throw new BusinessException("密码错误");
        }

        return G.jwt(sysUser.getId(), sysUser.getUsername());
    }
}
