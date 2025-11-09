package com.atguigu.mybatis.utils;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public void testGetEmpByEmpId() {
        SqlSession session = getSqlSession();

    }




}
