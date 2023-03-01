package com.ehsanzhao.springboot.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyuan
 * @date 2023/3/1
 */
@Component
public class MyInfoIndicator implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好");
    }
}
