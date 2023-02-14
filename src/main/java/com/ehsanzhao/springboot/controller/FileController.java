package com.ehsanzhao.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zhaoyuan
 * @date 2023/2/14
 */
@Slf4j
@Controller
public class FileController {

    /**
     * MultipartFile自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("username:{},email:{},headerImg={},photos={}",username,email,headerImg.getSize(),photos.length);
        if (!headerImg.isEmpty()) {
            headerImg.transferTo(new File(System.getProperty("user.dir") + File.separator + headerImg.getOriginalFilename()));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    photo.transferTo(new File(System.getProperty("user.dir") + File.separator + headerImg.getOriginalFilename()));
                }
            }
        }
        return "main";
    }

}
