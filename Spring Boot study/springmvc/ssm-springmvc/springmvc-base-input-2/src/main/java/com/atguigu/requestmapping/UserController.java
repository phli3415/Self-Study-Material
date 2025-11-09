package com.atguigu.requestmapping;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    /**
     * 精准设置访问地址 /user/login
     * 1.精准地址，(一个|多个) {"address1", "address2"}
     * 2.支持模糊地址*任意一层字符串， **任意字符串
     * /user/*： /user/a可以，/user/a/b 不行
     */
//    类上加了“user” 方法等于@RequestMapping(value = {"/user/login"})
    //method: 指定请求方式，不是指定的请求方式会报405, 可以用@PostMapping代替
    //同理的@GetMapping 等只能用在function上
    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    @ResponseBody
    public String login(){
        System.out.println("UserController.login");
        return "login success!!";
    }

    /**
     * 精准设置访问地址 /user/register
     */
    @RequestMapping(value = {"register"})
    @ResponseBody
    public String register(){
        System.out.println("UserController.register");
        return "register success!!";
    }
}
