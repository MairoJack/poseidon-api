package com.mario.poseidon.service;

import com.mario.poseidon.bean.dto.LectureDTO;
import com.mario.poseidon.bean.entity.Lecture;
import com.mario.poseidon.common.BaseService;
import com.mario.poseidon.dao.LectureDao;
import org.springframework.stereotype.Service;

@Service
public class LectureService extends BaseService<LectureDao, Lecture, LectureDTO> {
    public LectureService() {
        super(Lecture.class, "活动讲座");
    }

    @Override
    protected void checkExist(Lecture lecture, LectureDTO dto) {
        super.isExist(lecture.getId(), "name", dto.getName());
    }

}
