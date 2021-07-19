package com.mario.poseidon.bean.dto;

import com.mario.poseidon.bean.enums.SiteType;
import com.mario.poseidon.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author mario on 2021/7/19.
 */
@Getter
@Setter
public class SysUserDTO extends BaseDTO {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 50, message = "用户名不超过50字")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码6~20位")
    private String password;

    /**
     * 真实姓名
     */
    @Size(max = 50, message = "真实姓名不超过50字")
    private String realname;
}
