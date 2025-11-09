package com.atguigu.controller;


import com.atguigu.pojo.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    //想要让User的校验注解生效必须加@Validated
    //无论接到的是param 还是json都生效
    public User register(@Validated User user){
        System.out.println(user);
        return user;
    }


    //编程异常处理： 在程序里加try catch
    //全局异常处理: 建一个handler，加上@ControllerAdvice, 底层是AOP
    @GetMapping("data")
    public String data(){
//        String name = null;
//        name.toString();
        return "ok";
    }
    @GetMapping("data1")
    public String data1(){
//        int num = 1/0;
        return "ok";
    }
}
