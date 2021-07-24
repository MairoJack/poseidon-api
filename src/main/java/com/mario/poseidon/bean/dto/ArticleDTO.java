package com.mario.poseidon.bean.dto;

import com.mario.poseidon.bean.enums.SiteType;
import com.mario.poseidon.common.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author mario on 2021/7/24.
 */
@Getter
@Setter
public class ArticleDTO extends BaseDTO {

    /**
     * 标题
     */
    @NotEmpty(message = "标题不能为空")
    @Size(max = 100, message = "标题不超过100字")
    private String title;

    /**
     * 内容
     */
    @NotEmpty(message = "内容不能为空")
    private String content;

    /**
     * 地址
     */
    @NotEmpty(message = "地址不能为空")
    @Size(max = 200, message = "地址不超过200字")
    private String address;

    /**
     * 主图
     */
    @NotEmpty(message = "主图不能为空")
    @Size(max = 100, message = "主图不超过100")
    private String mainImage;

    /**
     * 站点
     */
    @NotNull(message = "站点不能为空")
    private SiteType site;

    /**
     * 日期
     */
    @NotNull(message = "日期不能为空")
    private LocalDate date;
}
