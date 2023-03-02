package com.ehsanzhao.springboot.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaoyuan
 * @date 2023/1/18
 */
@Controller
@Profile("pro")
public class HelloController {

    Counter counter;

    @Value("${person.name:ehsanzhao}")
    private String name;
    @Value("${person.age:100}")
    private String age;

    public HelloController(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("helloController.hello.count");
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        counter.increment();
//        int num = 10/0;
       return "Hi,"+name+","+age;
    }

}
