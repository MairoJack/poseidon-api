package com.mario.poseidon.service;

import com.mario.poseidon.bean.dto.SysUserDTO;
import com.mario.poseidon.bean.dto.UserDTO;
import com.mario.poseidon.bean.entity.SysUser;
import com.mario.poseidon.bean.entity.User;
import com.mario.poseidon.common.BaseService;
import com.mario.poseidon.dao.SysUserDao;
import com.mario.poseidon.dao.UserDao;
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

}
