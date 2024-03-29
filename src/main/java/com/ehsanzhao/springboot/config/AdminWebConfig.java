package com.ehsanzhao.springboot.config;

import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.ehsanzhao.springboot.intercepter.LoginIntercepter;
import com.ehsanzhao.springboot.intercepter.RedisUrlCountIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhaoyuan
 * @date 2023/2/14
 * @EnableWebMvc（慎用）  全面接管mvc  1、静态资源？试图解析器？欢迎……页全部失效
 * 所有的规则全部要自己重新配置
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * Filter、Intercepter 几乎功能一致
     * Filter是Servlet的原生组件，脱离的Spring依旧可以使用
     * Intercepter是Spring定义的接口，可以使用Spring的自动装配等功能
     */
    @Autowired
    private RedisUrlCountIntercepter redisUrlCountIntercepter;

    /**
     * 访问 /aa/** 都有请求都去 classpath:/static/ 下面进行匹配
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                //所有资源都会拦截，静态资源也会被拦截
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/resources/**","/hello","/sayhello","/data/**","/error","/aa/**");

        registry.addInterceptor(redisUrlCountIntercepter).addPathPatterns("/data/**");
    }

//    @Bean
//    public WebMvcRegistrations webMvcRegistrations(){
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return WebMvcRegistrations.super.getRequestMappingHandlerMapping();
//            }
//        };
//    }


}
