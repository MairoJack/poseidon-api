package com.mario.poseidon.controller;

import com.mario.poseidon.bean.dto.LectureDTO;
import com.mario.poseidon.bean.entity.Lecture;
import com.mario.poseidon.bean.search.LectureSearch;
import com.mario.poseidon.common.BaseController;
import com.mario.poseidon.service.LectureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lectures")
public class LectureController extends BaseController<Lecture, LectureDTO, LectureService, LectureSearch> {

    private final LectureService service;

    public LectureController(LectureService service) {
        super(service);
        this.service = service;
    }
}
