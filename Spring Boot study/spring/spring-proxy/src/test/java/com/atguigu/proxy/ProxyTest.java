package com.atguigu.proxy;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void testDynamicProxy(){
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        //不知道具体实现类，向上转型到接口
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.div(1,1);
        //proxy.div(1,1);
    }
}
