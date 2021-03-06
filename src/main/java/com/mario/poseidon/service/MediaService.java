package com.mario.poseidon.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mario.poseidon.bean.dto.MediaDTO;
import com.mario.poseidon.bean.entity.Media;
import com.mario.poseidon.bean.enums.MediaType;
import com.mario.poseidon.common.BaseService;
import com.mario.poseidon.dao.MediaDao;
import com.mario.poseidon.exception.BusinessException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class MediaService extends BaseService<MediaDao, Media, MediaDTO> {

    @Value("${file.path}")
    private String filePath;

    public MediaService() {
        super(Media.class, "媒体");
    }

    /**
     * 上传
     */
    public String upload(MultipartFile file) {
        try {
            String md5 = SecureUtil.md5(file.getInputStream());
            Media media = super.getOne(Wrappers.<Media>lambdaQuery().eq(Media::getMd5, md5));
            if (ObjectUtil.isNotNull(media)) {
                return media.getName();
            }
            String fileName = IdUtil.fastSimpleUUID() + "." + FileNameUtil.getSuffix(file.getOriginalFilename());
            FileUtil.writeFromStream(file.getInputStream(), filePath + fileName);
            media = new Media()
                    .setMd5(md5)
                    .setType(MediaType.IMAGE)
                    .setName(fileName);
            super.save(media);
            return fileName;
        } catch (Exception e) {
            log.error("文件上传异常:{}", e.getMessage());
            throw new BusinessException("文件上传异常");
        }

    }

}
