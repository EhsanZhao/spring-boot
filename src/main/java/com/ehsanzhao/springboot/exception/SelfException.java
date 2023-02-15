package com.ehsanzhao.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author zhaoyuan
 * @date 2023/2/15
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "xxx异常")
public class SelfException extends RuntimeException{

    public SelfException() {
    }

    public SelfException(String message) {
        super(message);
    }
}
