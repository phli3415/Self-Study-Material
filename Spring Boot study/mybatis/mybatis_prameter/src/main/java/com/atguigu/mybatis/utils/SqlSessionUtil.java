package com.atguigu.mybatis.utils;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;




public class SqlSessionUtil {
    public static SqlSession getSqlSession()  {
        SqlSession session = null;
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder factoryBuilder= new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = factoryBuilder.build(is);
            session = factory.openSession(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;

    }

    @Test
    public void testUpdate(){
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser();
        session.close();
    }

    @Test
    public void testInsert(){
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUser();
        session.close();
    }


    @Test
    public void testDelete(){
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser();
        session.close();
    }

    @Test
    public void testGet(){
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        user User = mapper.getUserById();
        System.out.println(User);
        session.close();
    }


    @Test
    public void testGetAll(){
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<user> Users = mapper.getUserList();
        Users.forEach(System.out::println);
        session.close();
    }


    @Test
    public void testGetUserByName() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        user User=mapper.getUserByName("abc");
        System.out.println(User);
        session.close();
    }


    @Test
    public void testCheckLogin() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        user User=mapper.checkLogin("abc", "123456");
        System.out.println(User);
        session.close();
    }

    @Test
    public void testCheckLoginByMap() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Map<String, Object> map=new HashMap<>();
        map.put("username","123");
        map.put("password","111111");

        user User=mapper.checkLoginByMap(map);
        System.out.println(User);
        session.close();
    }

    @Test
    public void testInsertUser() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        user User=new user("root",null,  "122334", 34, "f", "123@gmail.com");


        mapper.insertUserByClass(User);
        session.close();
    }

    @Test
    public void testCheckLoginByParam() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<user> User=mapper.checkLoginByParam("admin","123456");
        System.out.println(User);
        session.close();
    }


}
