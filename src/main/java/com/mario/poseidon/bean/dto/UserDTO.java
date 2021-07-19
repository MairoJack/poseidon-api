package com.mario.poseidon.bean.dto;

import com.mario.poseidon.bean.enums.Sex;
import com.mario.poseidon.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author mario on 2021/7/19.
 */
@Getter
@Setter
public class UserDTO extends BaseDTO {

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Size(max = 50, message = "用户名不超过50字")
    private String username;

    /**
     * 密码
     */
    @Size(min = 6, max = 20, message = "密码6~20位")
    private String password;

    /**
     * 真实姓名
     */
    @Size(max = 50, message = "真实姓名不超过50字")
    private String realname;

    /**
     * 性别
     */
    private Sex sex;

    /**
     * 手机号
     */
    @Length(min = 11, max = 11, message = "手机号11位")
    private String mobile;

    /**
     * 头像
     */
    @Size(max = 100, message = "头像不超过100")
    private String avatar;
}
