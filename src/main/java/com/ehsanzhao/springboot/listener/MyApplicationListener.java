package com.ehsanzhao.springboot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zhaoyuan
 * @date 2023/3/3
 */
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("MyApplicationListener...onApplicationEvent...");
    }
}
