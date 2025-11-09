package com.atguigu.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {


    @Autowired
    private ServletContext servletContext;
    /**
     * 如果想要获取请求或者响应对象,或者会话等,可以直接在形参列表传入,并且不分先后顺序!
     * 注意: 接收原生对象,并不影响参数接收!
     */
    @GetMapping("api")
    @ResponseBody
    public String api(HttpSession session , HttpServletRequest request,
                      HttpServletResponse response){
        //ServletContext
        //声明全局配置[最大的共享域]
        //web.xml里context param那些
        //1。request/session 获取
        //ServletContext = request.getServletContext();
        String method = request.getMethod();
        System.out.println("method = " + method);
        return "api";
    }
}
