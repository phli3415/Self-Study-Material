package com.atguigu.spring.test;


import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


//指定当前测试类在spring中的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean
//runwith可以扫描，之后就能用自动装配了
//This annotation tells JUnit to run your test with Spring's testing support instead of the standard JUnit runner
//Without it:
//
//        Spring's dependency injection won't work in your tests
//        You won't be able to autowire beans
//        The Spring application context won't be created
//        Your test will run as a plain JUnit test without any Spring functionality

@RunWith(SpringJUnit4ClassRunner.class)
//设置spring测试环境的配置文件
//This annotation tells Spring which configuration files to use to create the
// application context for testing
@ContextConfiguration("classpath:tx-annotation.xml")//：后面不能有空格
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testBuyBook(){
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql, "root", "123", 23, "f", "123@gmail.com");
        //输入一个sql语句和需要的所有参数
    }


    @Test
    public void testGetUserById(){
        String sql = "select * from t_user where id=?";
        List<User> users= jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class),7);
        //输入一个sql语句和需要的所有参数

        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testGetCount(){
        String sql = "select count(*) from t_user";
        Integer count= jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
