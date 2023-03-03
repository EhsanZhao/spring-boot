package com.ehsanzhao.hellospringbootstarterautoconfigure.auto;

import com.ehsanzhao.hellospringbootstarterautoconfigure.bean.HelloProperties;
import com.ehsanzhao.hellospringbootstarterautoconfigure.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoyuan
 * @date 2023/3/3
 */
@Configuration
@ConditionalOnMissingBean(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }

}
