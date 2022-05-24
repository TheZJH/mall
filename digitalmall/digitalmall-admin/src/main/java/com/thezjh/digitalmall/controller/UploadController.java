package com.thezjh.digitalmall.controller;

import com.thezjh.digitalmall.common.lang.Result;
import com.thezjh.digitalmall.config.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author thezjh
 * @create 2022/5/21 下午9:54
 */
@RestController
@RequestMapping("product")
@Slf4j
public class UploadController {

    @Autowired
    private UploadService uploadService;

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @PostMapping("image")
    public Result uploadImage(@RequestParam("file") MultipartFile file) {
        //TODO 腾讯云cos图片上传
        String url = uploadService.uploadImage(file);
        log.info("返回地址：【{}】", url);
        return Result.success(200, "上传成功", url);
    }
}