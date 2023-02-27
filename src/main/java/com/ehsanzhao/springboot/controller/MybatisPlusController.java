package com.ehsanzhao.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @GetMapping("/page")
    public Page<User> page(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        Page<User> page = userService.page(new Page<User>(pn, 2));
        log.info("查询结果：{}",page);
        return page;
    }


}
