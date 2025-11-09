package com.atguigu.spring.aop.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component// @Component注解保证这个切面类能够放入IOC容器
@Aspect// @Aspect表示这个类是一个切面类
@Order(1)//设置优先级，越小越先
public class LoggerAspect {

//     在切面中通过指定的注解将方法标识为通知方法
//    前置通知：使用@Before注解标识，在被代理的目标方法前执行
//    返回通知：使用@AfterReturning注解标识，在被代理的目标方法成功结束后执行（寿终正寝）
//    异常通知：使用@AfterThrowing注解标识，在被代理的目标方法异常结束后执行（死于非命）
//    后置通知：使用@After注解标识，在被代理的目标方法最终结束后执行（盖棺定论）
//    环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕整个被代理的目标方法，包
//            括上面四种通知对应的所有位置



//    相同目标方法上同时存在多个切面时，切面的优先级控制切面的内外嵌套顺序。
//
//    优先级高的切面：外面
//    优先级低的切面：里面
//    使用@Order注解可以控制切面的优先级：
//
//    @Order(较小的数)：优先级高
//    @Order(较大的数)：优先级低

//包名写全，避免同名method
    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int, int))")
    public void beforeAdviceMethod() {
        System.out.println("LoggerAspect: beforeAdviceMethod");
    }


    //切入点表达式重用
    //创造切面
    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {}



    //* com.atguigu.spring.aop.annotation.*(..)
    //第一个星：所有返回修饰符和返回类
    //第二个星：annotation包下所有class
    //


    //所有方法的所有参数

//    @AfterReturning中的属性returning，用来将通知方法的某个形参，接收目标方法的返回值，名字要一样
    //@AfterReturning("pointCut()")//创了切面后直接调用就行
    @AfterReturning(value = "execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))",
    returning = "result")//returning: 设置方法返回值的返回名
    public void afterAdviceMethod(JoinPoint joinPoint, Object result) {
        //JoinPoint：链接点的method
        //获取连接点所对应的签名信息
        Signature signature = joinPoint.getSignature();
        //链接点所对应的方法名
        System.out.println("LoggerAspect: afterAdviceMethod method:" + signature.getName());
        //连接点所有对应的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect: afterAdviceMethod parameters:" + args);
        System.out.println("result: "+result);


    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+methodName);
    }


//    @AfterThrowing中的属性throwing，用来将通知方法的某个形参，接收目标方法的异常
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
    }

}
