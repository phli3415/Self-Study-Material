package com.atguigu.param;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {
    /**
     * 前端请求: http://localhost:8080/param/value?name=xx&age=18
     * 可以利用形参列表,直接接收前端传递的param参数!
     *    要求: 参数名 = 形参名
     *          类型相同
     * 出现乱码正常，json接收具体解决！！
     * @return 返回前端数据
     */

//    handler接收参数
//    只要形参数名和类型与传递参数相同，即可自动接收!
    @GetMapping(value="/value")
    @ResponseBody
    public String setupForm(String name,int age){
        //名称一样才可以传递， 不传递也不报错
        System.out.println("name = " + name + ", age = " + age);
        return name + age;
    }


//    可以使用 `@RequestParam` 注释将 Servlet 请求参数
//    （即查询参数或表单数据）绑定到控制器中的方法参数。
//
//    `@RequestParam`使用场景：
//    指定绑定的请求参数名
//  - 要求请求参数必须传递
//  - 为请求参数提供默认值

    /**
     * 前端请求: http://localhost:8080/param/data?name=xx&stuAge=18
     *
     *  使用@RequestParam注解标记handler方法的形参
     *  指定形参对应的请求参数@RequestParam(请求参数名称)
     */
    @GetMapping(value="/data")
    @ResponseBody
    public Object paramForm(@RequestParam("name") String name,
                            @RequestParam(required = false, defaultValue = "1") int age){
        //name 必须传，age可以不传，默认值为1
        System.out.println("name = " + name + ", age = " + age);
        return name+age;
    }

    /**
     * 前端请求: http://localhost:8080/param/mul?hbs=吃&hbs=喝
     *
     *  一名多值,可以使用集合接收即可!但是需要使用@RequestParam注解指定
     */
    @GetMapping(value="/mul")
    @ResponseBody
    public Object mulForm(@RequestParam List<String> hbs){
        System.out.println("hbs = " + hbs);
        return hbs;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(User user) {
        // 在这里可以使用 user 对象的属性来接收请求参数
        //属性名必须等于参数名
        System.out.println("user = " + user);
        return "success";
    }
}
