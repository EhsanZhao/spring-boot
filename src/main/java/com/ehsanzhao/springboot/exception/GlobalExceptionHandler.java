package com.ehsanzhao.springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理全局的controller异常
 * @author zhaoyuan
 * @date 2023/2/15
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handlerException(){
        return "";
    }

}
