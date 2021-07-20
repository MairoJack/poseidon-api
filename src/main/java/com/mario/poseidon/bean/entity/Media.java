package com.mario.poseidon.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mario.poseidon.bean.enums.MediaType;
import com.mario.poseidon.bean.enums.Sex;
import com.mario.poseidon.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author mario on 2021/7/20.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pd_media")
public class Media extends BaseEntity {

    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private MediaType type;
    /**
     * md5
     */
    private String md5;

}
