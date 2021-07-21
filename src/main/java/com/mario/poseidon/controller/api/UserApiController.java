package com.mario.poseidon.controller.api;

import com.mario.poseidon.bean.dto.UserDTO;
import com.mario.poseidon.bean.entity.User;
import com.mario.poseidon.bean.form.LoginForm;
import com.mario.poseidon.service.UserService;
import com.mario.poseidon.utils.ContextHolder;
import com.mario.poseidon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserApiController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public R<?> register(@RequestBody @Validated UserDTO dto) {
        service.create(dto);
        return R.ok();
    }

    @PostMapping("login")
    public R<String> login(@RequestBody @Validated LoginForm form) {
        return R.ok(service.login(form));
    }

    @GetMapping("info")
    public R<User> info() {
        return R.ok(service.get(ContextHolder.getUserInfo().getId()));
    }


}
