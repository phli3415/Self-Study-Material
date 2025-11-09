package com.atguigu.json;

import com.atguigu.pojo.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller

@RestController
//@RestController+@Controller+@ResponseBody
public class JsonController {


    @GetMapping("data")
    @ResponseBody
    public user data(){
        //对象-》json-》{}
        //集合-》json->[]
        user User = new user();
        User.setAge(3);
        User.setName("bob");
        return User;//user会在handlerAdatper中被转成·json、
        //再加一个responseBody注解
        //返回的对象,会使用jackson的序列化工具,转成json返回给前端!
        //这叫前后端分离

    }

    @GetMapping("data2")
    @ResponseBody
    public List<user> data1(){
        user User = new user();
        User.setName("Ami");
        User.setAge(3);
        List <user> list = new ArrayList();
        list.add(User);
        return list;
    }
}
