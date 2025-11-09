package com.atguigu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//config 里面设置handler
public class MyInterceptor implements HandlerInterceptor {

    // if( ! preHandler()){return;}
    // 在处理请求的目标 handler 方法前执行
    // 编码格式设置，登录保护等

    //HttpServletRequest：请求对象
    //HttpServletResponse： 返回对象
    //handler：要调用的方法（handler）
    //return: true 放行 false:拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler);
        System.out.println("Process01Interceptor.preHandle");

        // 返回true：放行
        // 返回false：不放行
        return true;
    }

    // 在目标 handler 方法之后，handler报错不执行!
    //preHandle return true 才触发 因为在执行后触发： 无法拦截
    //ModelAndView：返回的视图/共享域
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", modelAndView = " + modelAndView);
        System.out.println("Process01Interceptor.postHandle");
    }

    // 渲染视图之后执行(最后),一定执行!
    //ex：handler报错了的异常对象
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", ex = " + ex);
        System.out.println("Process01Interceptor.afterCompletion");
    }}
