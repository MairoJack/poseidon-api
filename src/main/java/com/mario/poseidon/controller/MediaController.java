package com.mario.poseidon.controller;

import cn.hutool.core.collection.CollUtil;
import com.mario.poseidon.exception.BusinessException;
import com.mario.poseidon.service.MediaService;
import com.mario.poseidon.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("medias")
public class MediaController {

    @Autowired
    private MediaService service;

    @PostMapping("multi")
    public R<List<String>> multi(MultipartFile[] files) {
        if (files.length <= 0 || files.length > 5) {
            throw new BusinessException("上传限制1~5");
        }
        List<String> list = CollUtil.newArrayList();
        for (MultipartFile file : files) {
            list.add(service.upload(file));
        }
        return R.ok(list);
    }

    @PostMapping("single")
    public R<String> single(MultipartFile file) {
        return R.ok(service.upload(file));
    }

}
