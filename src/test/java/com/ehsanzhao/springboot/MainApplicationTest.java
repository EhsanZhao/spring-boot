package com.ehsanzhao.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @author zhaoyuan
 * @date 2023/2/17
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test(){
        Long aLong = jdbcTemplate.queryForObject("select count(1) from user", Long.class);
        log.info("查询结果：{}",aLong);
        log.info("数据源为：{}",dataSource.getClass());
    }

}
