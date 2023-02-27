package com.ehsanzhao.springboot.controller;

import com.ehsanzhao.springboot.entity.User;
import com.ehsanzhao.springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyuan
 * @date 2023/2/17
 */
@Slf4j
@RestController
@RequestMapping("/data/mybatis")
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public User query(@RequestParam("user") String userName){
        User user = userMapper.getUser(userName);
        log.info("查询结果：{}",user);
        return user;
    }

}
