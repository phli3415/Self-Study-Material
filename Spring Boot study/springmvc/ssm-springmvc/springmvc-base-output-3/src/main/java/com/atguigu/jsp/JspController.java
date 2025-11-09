package com.atguigu.jsp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {


    //不能加@responseBody
    @GetMapping("index")
    public String index(HttpServletRequest request) {
        request.setAttribute("data", "hello");//放个数据
        return "index";//加上前后缀自动跳到指定文件
    }





//    在 Spring MVC 中，Handler 方法返回值来实现快速转发，
//    可以使用 redirect 或者 forward 关键字来实现重定向。

    //转发 //只能是项目下的资源
    //1.方法返回写成字符串
    //2.别加@responseBody
    //3.地址前加 forward
    @RequestMapping("forward")
    public String forwardDemo() {
        // 转发到 /demo 路径
        return "forward:/jsp/index";
    }


    //重定向
    //1.方法返回写成字符串
    //2.别加@responseBody
    //3.地址前加redirect
    @RequestMapping("redirect")
    public String redirectDemo() {
        // 重定向到 /demo 路径
        return "redirect:/jsp/index";
    }

    //注意： 转发和重定向到项目下资源路径都是相同，都不需要添加项目根路径！填写项目下路径即可！
    //重定向到第三方地址， 写全

    @RequestMapping("redirectGoogle")
    public String redirectGoogle() {
        return "redirect:https://www.geeksforgeeks.org/java-full-stack/";
        //第三方写全
    }
}
