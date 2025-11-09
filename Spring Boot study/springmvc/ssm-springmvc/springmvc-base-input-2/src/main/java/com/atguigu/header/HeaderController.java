package com.atguigu.header;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("header")
@ResponseBody
public class HeaderController {

    //get header
    @GetMapping("data")
    public String data(@RequestHeader("host")String host){
        System.out.println(host);
        return host;
    }
}
