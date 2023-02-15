package com.ehsanzhao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyuan
 * @date 2023/1/18
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        int num = 10/0;
       return "Hi,Spring boot 2";
    }

}
