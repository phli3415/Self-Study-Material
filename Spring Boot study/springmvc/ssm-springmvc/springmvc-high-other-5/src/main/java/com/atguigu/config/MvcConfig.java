package com.atguigu.config;


import com.atguigu.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.atguigu")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {


    //注入interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置方案1：拦截全部请求
        registry.addInterceptor(new MyInterceptor());

        //配置方案2：拦截指定地址请求
        registry.addInterceptor(new MyInterceptor()).
                addPathPatterns("/user/data");//拦截所有的话/user/**

        //配置方案3：拦截除指定地址请求外所有请求
        registry.addInterceptor(new MyInterceptor()).
                addPathPatterns("/user/**").excludePathPatterns("/user/data");

    }
}
