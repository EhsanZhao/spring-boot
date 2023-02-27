package com.ehsanzhao.springboot.controller;

import com.ehsanzhao.springboot.entity.User;
import com.ehsanzhao.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaoyuan
 * @date 2023/2/17
 */
@Slf4j
@RestController
@RequestMapping("/data/mybatisplus")
public class MybatisPlusController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> query(){
        List<User> user = userService.list();
        log.info("查询结果：{}",user);
        return user;
    }


}
