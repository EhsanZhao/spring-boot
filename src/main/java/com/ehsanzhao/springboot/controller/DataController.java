package com.ehsanzhao.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoyuan
 * @date 2023/2/17
 */
@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public Long query(){
        Long aLong = jdbcTemplate.queryForObject("select count(1) from user", Long.class);
        log.info("查询结果：{}",aLong);
        return aLong;
    }

}
