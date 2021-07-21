package com.mario.poseidon.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mario.poseidon.bean.dto.UserDTO;
import com.mario.poseidon.bean.entity.User;
import com.mario.poseidon.bean.form.LoginForm;
import com.mario.poseidon.common.BaseService;
import com.mario.poseidon.dao.UserDao;
import com.mario.poseidon.exception.BusinessException;
import com.mario.poseidon.utils.G;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<UserDao, User, UserDTO> {

    public UserService() {
        super(User.class, "会员");
    }

    @Override
    protected void checkExist(User user, UserDTO dto) {
        super.isExist(user.getId(), "username", dto.getUsername());
    }

    @Override
    public ICreateExtend<User, UserDTO> createExtend() {
        return new ICreateExtend<>() {
            @Override
            public void before(User user, UserDTO dto) {
                user.setPassword(G.sha256(dto.getPassword()));
            }
        };
    }

    @Override
    public IModifyExtend<User, UserDTO> modifyExtend() {
        return new IModifyExtend<>() {
            @Override
            public void before(User user, UserDTO dto) {
                if (StrUtil.isNotEmpty(dto.getPassword())) {
                    user.setPassword(G.sha256(dto.getPassword()));
                }
            }
        };
    }

    public String login(LoginForm form) {
        User user = super.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, form.getUsername()));
        if (user == null) {
            throw new BusinessException("账号不存在");
        }
        if (!StrUtil.equals(user.getPassword(), G.sha256(form.getPassword()))) {
            throw new BusinessException("密码错误");
        }

        return G.jwt(user.getId(), user.getUsername());
    }
}
