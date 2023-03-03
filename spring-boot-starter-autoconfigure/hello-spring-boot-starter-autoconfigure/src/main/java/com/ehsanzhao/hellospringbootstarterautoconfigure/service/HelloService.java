package com.ehsanzhao.hellospringbootstarterautoconfigure.service;

import com.ehsanzhao.hellospringbootstarterautoconfigure.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaoyuan
 * @date 2023/3/3
 */
public class HelloService {

    @Autowired
    private HelloProperties helloProperties;

    public String sayHello(String helloName){
        return helloProperties.getPrefix()+" "+helloName+">>>"+helloProperties.getSuffix();
    }

}
