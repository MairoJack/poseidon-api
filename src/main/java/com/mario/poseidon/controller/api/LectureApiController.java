package com.mario.poseidon.controller.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mario.poseidon.bean.dto.LectureDTO;
import com.mario.poseidon.bean.entity.Lecture;
import com.mario.poseidon.bean.search.LectureSearch;
import com.mario.poseidon.common.BaseController;
import com.mario.poseidon.service.LectureService;
import com.mario.poseidon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/lectures")
public class LectureApiController {

    @Autowired
    private LectureService service;

    @GetMapping()
    public R<IPage<Lecture>> page(Page<Lecture> page, LectureSearch search) {
        return R.ok(service.page(page, search));
    }

}
