package com.atguigu.spring.test;

import com.atguigu.spring.aop.annotation.Calculator;
import com.atguigu.spring.aop.annotation.CalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    @Test
    public void testAOPByAnnotation() {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        //aop启动后不能访问目标对象，只能访问代理对象
        //调用接口
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1, 2);
    }
}
