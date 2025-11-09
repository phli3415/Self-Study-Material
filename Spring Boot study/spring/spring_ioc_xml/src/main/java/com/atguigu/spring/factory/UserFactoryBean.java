package com.atguigu.spring.factory;

import com.atguigu.spring.pojo.User;
import org.springframework.beans.factory.FactoryBean;


//FactoryBean是Spring提供的一种整合第三方框架的常用机制。和普通的bean不同，配置一个
//FactoryBean类型的bean，在获取bean的时候得到的并不是class属性中配置的这个类的对象，而是
//getObject()方法的返回值。通过这种机制，Spring可以帮我们把复杂组件创建的详细过程和繁琐细节都屏蔽起来，只把最简洁的使用界面展示给我们。
//将来我们整合Mybatis时，Spring就是通过FactoryBean机制来帮我们创建SqlSessionFactory对象的。

//factorybean 是一个接口，需要创建一个类去实现
//三个方法:
//getObject(): 返回一个对象交给IOC容器管理
//getObjectType(): 设置所提供对象的类型
//isSingleton(): 所提供的对象是否单例
//当把factoryBean的实现类配置为bean时，会将当前类中getObject返回的对象交给ioc容器管理-->
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }
    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}