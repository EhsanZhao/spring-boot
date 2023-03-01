package com.ehsanzhao.springboot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author zhaoyuan
 * @date 2023/3/1
 */
@Component
@Endpoint(id = "docker")
public class MyEndPoint {

    @ReadOperation
    public Object getDockerInfo(){
        //端点的读操作
        return Collections.singletonMap("dockerInfo","docker started...");
    }

    @WriteOperation
    public void stopDocker(){
        //端点的写操作
        System.out.println("stop docker...");
    }

}
