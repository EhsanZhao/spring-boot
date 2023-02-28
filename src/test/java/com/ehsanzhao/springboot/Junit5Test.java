package com.ehsanzhao.springboot;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoyuan
 * @date 2023/2/28
 */
//@SpringBootTest // 使用SpringBoot的功能，不用可以不添加
@DisplayName("Junit5测试")
public class Junit5Test {

    @Test
    @DisplayName("@DispalyName")
    public void testDisplayName(){
        System.out.println(1);
    }

    @Test
    @Disabled
    @DisplayName("@DispalyName2")
    public void testDisplayName2(){
        System.out.println(2);
    }

    @Test
    @RepeatedTest(5)
    public void testRepeatedTest(){
        System.out.println("RepeatedTest");
    }

    @Test
    @Timeout(value = 1000,unit = TimeUnit.MILLISECONDS)
    public void testTimeout() throws InterruptedException {
        Thread.sleep(1001);
        System.out.println("Timeout");
    }

    @BeforeEach
    public void testBeforeEach(){
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void testAfterEach(){
        System.out.println("AfterEach");
    }

    @BeforeAll
    public static void testBeforeAll(){
        System.out.println("BeforeAll");
    }

    @AfterAll
    public static void testAfterAll(){
        System.out.println("AfterAll");
    }

}
