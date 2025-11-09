package com.atguigu.share;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("share")
@ResponseBody
public class ShareController {
    @Autowired//对，这玩意也能自动装配
    private ServletContext servletContext;


    //原生api
    public void data(HttpSession session , HttpServletRequest request){

    }

    //springMvc的方案: 提供了几种方案
    //Model, ModelMap, Map, request, ModelAndView
    //跳了
    //https://www.wolai.com/mY4orG21749UeVBHsefaAb //2.6.2


    @RequestMapping("/attr/request/model")
    @ResponseBody
    public String testAttrRequestModel(
            // 在形参位置声明Model类型变量，用于存储模型数据
            Model model) {
        // 我们将数据存入模型，SpringMVC 会帮我们把模型数据存入请求域
        // 存入请求域这个动作也被称为暴露到请求域 （request域）
        model.addAttribute("requestScopeMessageModel","i am very happy[model]");
        return "target";
    }


    @RequestMapping("/attr/request/model/map")
    @ResponseBody
    public String testAttrRequestModelMap(
            // 在形参位置声明ModelMap类型变量，用于存储模型数据
            ModelMap modelMap) {
        // 我们将数据存入模型，SpringMVC 会帮我们把模型数据存入请求域
        // 存入请求域这个动作也被称为暴露到请求域
        modelMap.addAttribute("requestScopeMessageModelMap","i am very happy[model map]");
        return "target";
    }


    @RequestMapping("/attr/request/map")
    @ResponseBody
    public String testAttrRequestMap(
            // 在形参位置声明Map类型变量，用于存储模型数据
            Map<String, Object> map) {
        // 我们将数据存入模型，SpringMVC 会帮我们把模型数据存入请求域
        // 存入请求域这个动作也被称为暴露到请求域
        map.put("requestScopeMessageMap", "i am very happy[map]");
        return "target";
    }

    @RequestMapping("/attr/request/original")
    @ResponseBody
    public String testAttrOriginalRequest(
            // 拿到原生对象，就可以调用原生方法执行各种操作
            HttpServletRequest request) {
        request.setAttribute("requestScopeMessageOriginal", "i am very happy[original]");
        return "target";
    }

    @RequestMapping("/attr/request/mav")
    public ModelAndView testAttrByModelAndView() {
        // 1.创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 2.存入模型数据
        modelAndView.addObject("requestScopeMessageMAV", "i am very happy[mav]");
        // 3.设置视图名称
        modelAndView.setViewName("target");
        return modelAndView;//返回视图名称
    }


}
