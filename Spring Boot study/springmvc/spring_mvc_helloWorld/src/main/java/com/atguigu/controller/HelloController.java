package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String portal() {
//        将逻辑视图返回
        return "index";//这个值会被web.xml解析，加上前后缀并调到指定页面
    }
}
