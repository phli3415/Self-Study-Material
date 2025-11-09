package com.atguigu.error;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//全局异常处理器

/**
 * projectName: com.atguigu.execptionhandler
 *
 * description: 全局异常处理器,内部可以定义异常处理Handler!
 */

/**
 * @RestControllerAdvice = @ControllerAdvice + @ResponseBody
 * @ControllerAdvice 代表当前类的异常处理controller!
 */

//Advice 代表全局异常处理器，有异常会自动调用
//@ControllerAdvice//可以返回字符串（用逻辑视图重定向
@RestControllerAdvice//等于@ControllerAdvice+@ResponseBody 反字符串
public class GlobalExceptionHandler {

    //发生异常->ControllerAdvice->ExceptionHandler->handler
    //没有找到具体的异常会去找这个异常的父类的处理器：example ： @ExceptionHandler(Exception.class)

    @ExceptionHandler(ArithmeticException.class)//指定处理数学异常
    public Object ArithmaticExceptionHandler(ArithmeticException e) {
        //自定义处理方法
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)//指定处理数学异常
    public Object ExceptionHandler(Exception e) {
        //自定义处理方法
        return e.getMessage();

    }
}
