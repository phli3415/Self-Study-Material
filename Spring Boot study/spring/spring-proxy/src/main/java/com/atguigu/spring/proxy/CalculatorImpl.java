package com.atguigu.spring.proxy;

//①现有代码缺陷
//针对带日志功能的实现类，我们发现有如下缺陷：
//
//对核心业务功能有干扰，导致程序员在开发核心业务功能时分散了精力
//附加功能分散在各个业务功能方法中，不利于统一维护
//②解决思路
//解决这两个问题，核心就是：解耦。我们需要把附加功能从业务功能代码中抽取出来。
//
//        ③困难
//解决问题的困难：要抽取的代码在方法内部，靠以前把子类中的重复代码抽取到父类的方式没法解决。所以需要引入新的技术。


//二十三种设计模式中的一种，属于结构型模式。它的作用就是通过提供一个代理类
//，让我们在调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理
//类间接调用。让不属于目标方法核心逻辑的代码从目标方法中剥离出来——解耦。调
//用目标方法时先调用代理对象的方法，
//减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护


public class CalculatorImpl implements Calculator {

//    核心代码
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
