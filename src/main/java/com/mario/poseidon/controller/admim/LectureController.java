package com.mario.poseidon.controller.admim;

import com.mario.poseidon.bean.dto.LectureDTO;
import com.mario.poseidon.bean.entity.Lecture;
import com.mario.poseidon.bean.search.LectureSearch;
import com.mario.poseidon.common.BaseController;
import com.mario.poseidon.service.LectureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/lectures")
public class LectureController extends BaseController<Lecture, LectureDTO, LectureService, LectureSearch> {


    public LectureController(LectureService service) {
        super(service);
    }

}
