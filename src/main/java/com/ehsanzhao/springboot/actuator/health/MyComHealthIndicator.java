package com.ehsanzhao.springboot.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Actuator
 * 自定义EndPoint
 * @author zhaoyuan
 * @date 2023/3/1
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String,Object> map = new HashMap<>();
        if(1 == 1){
//            builder.up();
            builder.status(Status.UP);
            map.put("count",1);
            map.put("ms",100);
        }else{
//            builder.down();
            builder.status(Status.OUT_OF_SERVICE);
            map.put("err","连接超时");
            map.put("ms","3000");
        }

        builder.withDetail("code",100).withDetails(map);

    }
}
