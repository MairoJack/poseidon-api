package com.mario.poseidon.bean.search;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mario.poseidon.bean.entity.Media;
import com.mario.poseidon.common.BaseSearch;
import lombok.Getter;
import lombok.Setter;

/**
 * @author mario on 2021/7/20.
 */
@Getter
@Setter
public class MediaSearch implements BaseSearch<Media> {

    @Override
    public Wrapper<Media> query() {
        return Wrappers
                .<Media>lambdaQuery()
                .orderByDesc(Media::getId)
                ;
    }
}
