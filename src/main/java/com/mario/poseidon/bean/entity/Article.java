package com.mario.poseidon.bean.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mario.poseidon.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 文章
 *
 * @author mario on 2021/7/24.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pd_article")
public class Article extends BaseEntity {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 主图
     */
    private String mainImage;

    /**
     * 作者
     */
    private String author;

    /**
     * 阅读数
     */
    private int readNum;

}
