package com.mario.poseidon.controller;

import com.mario.poseidon.bean.dto.LectureDTO;
import com.mario.poseidon.bean.dto.SysUserDTO;
import com.mario.poseidon.bean.entity.Lecture;
import com.mario.poseidon.bean.entity.SysUser;
import com.mario.poseidon.bean.search.LectureSearch;
import com.mario.poseidon.bean.search.SysUserSearch;
import com.mario.poseidon.common.BaseController;
import com.mario.poseidon.service.LectureService;
import com.mario.poseidon.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys_users")
public class SysUserController extends BaseController<SysUser, SysUserDTO, SysUserService, SysUserSearch> {

    private final SysUserService service;

    public SysUserController(SysUserService service) {
        super(service);
        this.service = service;
    }
}
