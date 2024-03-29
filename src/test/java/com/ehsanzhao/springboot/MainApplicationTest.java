package com.ehsanzhao.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author zhaoyuan
 * @date 2023/2/17
 */
@Slf4j
@SpringBootTest
public class MainApplicationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    public void test(){
        Long aLong = jdbcTemplate.queryForObject("select count(1) from user", Long.class);
        log.info("查询结果：{}",aLong);
        log.info("数据源为：{}",dataSource.getClass());
    }

    @Test
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("hello","world");
        log.info("查询结果：{}",stringRedisTemplate.opsForValue().get("hello"));
        log.info("数据源为：{}",redisConnectionFactory.getClass());
    }

}
