package com.mario.poseidon.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author mario on 2021/7/19.
 */
@Getter
@Setter
@Accessors(chain = true)
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 操作人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String operator;
}
