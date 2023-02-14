package com.ehsanzhao.springboot.config;

import com.ehsanzhao.springboot.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhaoyuan
 * @date 2023/2/14
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                //所有资源都会拦截，静态资源也会被拦截
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/resources/**");
    }
}
