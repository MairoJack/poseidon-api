package com.mario.poseidon.controller;

import com.mario.poseidon.bean.dto.UserDTO;
import com.mario.poseidon.bean.entity.User;
import com.mario.poseidon.bean.search.UserSearch;
import com.mario.poseidon.common.BaseController;
import com.mario.poseidon.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController<User, UserDTO, UserService, UserSearch> {

    public UserController(UserService service) {
        super(service);
    }


}
