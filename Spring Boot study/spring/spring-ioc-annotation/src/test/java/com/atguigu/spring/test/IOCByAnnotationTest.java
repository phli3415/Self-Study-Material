package com.atguigu.spring.test;

import com.atguigu.spring.controller.userController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

//    @Component：将类标识为普通组件
//    @Controller：将类标识为控制层组件
//    @Service：将类标 识为业务层组件
//    @Repository：将类标识为持久层组件
//    对于Spring使用IOC容器管理这些组件来说没有区别。所以@Controller、@Service、@Repository这
//
//三个注解只是给开发人员看的，让我们能够便于分辨组件的作用。


//    ②@Autowired注解
//    在成员变量，在包含该变量的有参构造上，或set方法上直接标记@Autowired注解即可完成自动装配。
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        userController UserController = ac.getBean(userController.class);
        System.out.println(UserController);
        UserService userService = ac.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = ac.getBean(UserDao.class);
        System.out.println(userDao);
        UserController.saveUser();


    }
}
