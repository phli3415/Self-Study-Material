package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, null, null,null);
        List<Emp> emps=mapper.getEmpByCondition(emp);
        for (Emp emp1 : emps) {
            System.out.println(emp1);
        }
    }
    @Test
    public void testInsertMore() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a1", 45,"m");
        Emp emp2 = new Emp(null, "a2", 45,"m");
        Emp emp3 = new Emp(null, "a2", 45,"m");
        List<Emp> emps= Arrays.asList(emp1,emp2,emp3);
        mapper.insertMore(emps);

    }


    @Test
    public void testDeleteMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);


        mapper.deleteMoreEmp(new Integer[]{6,7});

    }
}
