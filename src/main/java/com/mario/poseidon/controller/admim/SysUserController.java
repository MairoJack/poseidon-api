package com.mario.poseidon.controller.admim;

import com.mario.poseidon.bean.dto.SysUserDTO;
import com.mario.poseidon.bean.entity.SysUser;
import com.mario.poseidon.bean.form.LoginForm;
import com.mario.poseidon.bean.search.SysUserSearch;
import com.mario.poseidon.common.BaseController;
import com.mario.poseidon.service.SysUserService;
import com.mario.poseidon.utils.ContextHolder;
import com.mario.poseidon.utils.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/sys_users")
public class SysUserController extends BaseController<SysUser, SysUserDTO, SysUserService, SysUserSearch> {

    public SysUserController(SysUserService service) {
        super(service);
    }

    @PostMapping("login")
    public R<String> login(@RequestBody @Validated LoginForm form) {
        return R.ok(service.login(form));
    }

    @GetMapping("info")
    public R<SysUser> info() {
        return R.ok(service.get(ContextHolder.getUserInfo().getId()));
    }

}
