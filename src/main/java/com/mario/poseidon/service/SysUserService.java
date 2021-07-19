package com.mario.poseidon.service;

import com.mario.poseidon.bean.dto.LectureDTO;
import com.mario.poseidon.bean.dto.SysUserDTO;
import com.mario.poseidon.bean.entity.Lecture;
import com.mario.poseidon.bean.entity.SysUser;
import com.mario.poseidon.common.BaseService;
import com.mario.poseidon.dao.LectureDao;
import com.mario.poseidon.dao.SysUserDao;
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

}
