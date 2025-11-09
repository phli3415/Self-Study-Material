package com.atguigu.json;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("json")
@Controller
@ResponseBody
public class JsonController {

    //java只支持路径和param，不支持json
    //解决：导入json依赖， 2.handlerAdaptor 配置json处理器， config里加@EnableWebMvc
    @PostMapping("/person")
    @ResponseBody
    public String addPerson(@RequestBody Person person) {

        // 在这里可以使用 person 对象来操作 JSON 数据中包含的属性
        return "success";
    }
}
