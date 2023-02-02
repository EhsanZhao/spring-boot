package com.ehsanzhao.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyuan
 * @date 2023/1/18
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
       return "Hi,Spring boot 2";
    }

}
