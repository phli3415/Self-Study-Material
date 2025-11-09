package com.atguigu.spring.proxy;

//每次都通过代理对象间接去访问核心对象
//代理类要和目标类实现相同的接口


//静态代理确实实现了解耦，但是由于代码都写死了，完全不具备任何的灵活性。就拿日志功能来
//
//说，将来其他地方也需要附加日志，那还得再声明更多个静态代理类，那就产生了大量重复的代
//
//码，日志功能还是分散的，没有统一管理。
//
//提出进一步的需求：将日志功能集中到一个代理类中，将来有任何日志需求，都通过这一个代理
//
//类来实现。这就需要使用动态代理技术了。
public class CalculatorStaticProxy implements Calculator {
//    非核心代码
    //通过静态代理分开，方便修改
    private CalculatorImpl target;

    public CalculatorImpl getTarget() {
        return target;
    }

    public void setTarget(CalculatorImpl target) {
        this.target = target;
    }

    public CalculatorStaticProxy(CalculatorImpl target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
        int result=target.add(i, j);
        System.out.println("[日志] add 方法结束了，结果是：" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始了，参数是：" + i + "," + j);
        int result=target.sub(i, j);
        System.out.println("[日志] sub 方法结束了，结果是：" + result);
        return result;    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始了，参数是：" + i + "," + j);
        int result=target.mul(i, j);
        System.out.println("[日志] mul 方法结束了，结果是：" + result);
        return result;    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);
        int result=target.div(i, j);
        System.out.println("[日志] div 方法结束了，结果是：" + result);
        return result;    }
}
