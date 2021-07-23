package com.mario.poseidon.bean.search;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mario.poseidon.bean.entity.Lecture;
import com.mario.poseidon.bean.enums.SiteType;
import com.mario.poseidon.common.BaseSearch;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mario on 2021/7/19.
 */
@Getter
@Setter
public class LectureSearch implements BaseSearch<Lecture> {

    private String name;
    private SiteType site;

    @Override
    public Wrapper<Lecture> query() {
        return Wrappers
                .<Lecture>lambdaQuery()
                .like(StrUtil.isNotBlank(name), Lecture::getName, name)
                .eq(ObjectUtil.isNotNull(site), Lecture::getSite, site)
                .orderByDesc(Lecture::getId)
                ;
    }
}
