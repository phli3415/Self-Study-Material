package com.atguigu.spring.test;

import com.atguigu.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test() {
        //获取ioc容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        //获取ioc容器中的bean
        HelloWorld helloworld = (HelloWorld)ioc.getBean(HelloWorld.class);
        helloworld.sayHello();
    }
}
