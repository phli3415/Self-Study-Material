package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    @Test
    public void testIOC() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//      三种获取bean的方法
//      1.根据id获取
//      Student studentOne = (Student)ioc.getBean("studentOne");
//      2.根据类型获取  如果有多个同类型的bean会报错
//      ioc容器里必须要有且只有一个该类型的bean， 不然报错
//      Student studentOne = ioc.getBean(Student.class);
//      Person studentOne = ioc.getBean(Person.class);
//      可以通过父类或接口去匹配bean
//      如果组件类实现了接口，根据接口类型可以获取 bean 吗？
//      可以，前提是bean唯一
//      如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗？
//      不行，因为bean不唯一



//      3.根据id和类型
        Student studentOne = (Student) ioc.getBean("studentOne",Student.class );
//      一般第二种用的最多，应为一般就只开一个bean
//      要用bean的话必须要有无参构造
        System.out.println(studentOne);
    }


    @Test
    public void testDI() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        Student studentOne = (Student) ioc.getBean("studentTwo",Student.class );
        System.out.println(studentOne);
    }


    @Test
    public void testDI2() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        Student studentOne = (Student) ioc.getBean("studentThree",Student.class );
        System.out.println(studentOne);
    }

    @Test
    public void testDI4() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        Student studentOne = (Student) ioc.getBean("studentFour",Student.class );
        System.out.println(studentOne);


    }

    @Test
    public void testDI5() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        Student studentOne = (Student) ioc.getBean("studentFive",Student.class );
        System.out.println(studentOne);
    }

    @Test
    public void testDI6() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        Student studentOne = (Student) ioc.getBean("studentSix",Student.class );
        System.out.println(studentOne);
    }

    @Test
    public void testClass1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCOntext.xml");
        Clazz clazzOne = (Clazz) ioc.getBean("clazzOne",Clazz.class );
        System.out.println(clazzOne);
    }
}
