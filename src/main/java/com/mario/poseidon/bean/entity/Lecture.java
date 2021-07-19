package com.mario.poseidon.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mario.poseidon.bean.enums.SiteType;
import com.mario.poseidon.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * @author mario on 2021/7/19.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pd_lecture")
public class Lecture extends BaseEntity {

    /**
     * 主题
     */
    private String subject;

    /**
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;
    /**
     * 站点
     */
    private SiteType site;

    /**
     * 日期
     */
    private LocalDate date;

}
