package com.ehsanzhao.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhaoyuan
 * @date 2023/2/28
 */
@DisplayName("测试断言")
public class AssertTest {

    /**
     * 前面断言失败，会报错，后面不会执行
     */
    @Test
    @DisplayName("测试简单断言")
    void testSimpleAssertions(){
        int num = cal(2,3);
        //相等
        assertEquals(5,num,"业务逻辑失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        //引用地址
//        assertSame(obj1,obj2,"两个对象不一样");
        //数组
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
        //异常断言，判断一定出现异常
        assertThrows(ArithmeticException.class,()->{int t = 1/0;},"业务逻辑居然没有失败");
        //快速失败
        fail("快速失败");
        //组合断言
        assertAll("组合断言", ()->{
                assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
                assertSame(obj1,obj2,"两个对象不一样");
            },
                ()-> assertTrue(true && false)
        );
    }

    /**
     * 前置条件不通过，不会报错，后面不会执行
     */
    @Test
    @DisplayName("测试前置条件")
    void testAssumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("测试前置条件");
    }

    /**
     * 参数化测试
     */
    @DisplayName("参数化测试")
    @ParameterizedTest
//    @ValueSource(ints = {1,2,3,4})
    @MethodSource("stringProvider")
    void testParameterized(int i){
        System.out.println(i);
    }

    static Stream<Integer> stringProvider(){
        return Stream.of(1,2,3,4,5);
    }

    int cal(int i,int j){
        return i+j;
    }

}
