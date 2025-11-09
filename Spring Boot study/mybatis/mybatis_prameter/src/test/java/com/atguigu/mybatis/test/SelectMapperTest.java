package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.user;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void testGetUserById(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        user User = mapper.getUserById(4);
        System.out.println(User);

    }

    @Test
    public void testGetAll(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<user> Users = mapper.getUserList();
        Users.forEach(System.out::println);
        session.close();
    }

    @Test
    public void testGetCount(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);

    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(5);
        System.out.println(map);

    }

    @Test
    public void testGetAllToMap(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllToMap();
        System.out.println(map);

    }

    @Test
    public void testGetUserByLike(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        List<user> Users= mapper.getUserByLike("a");
        for(user user:Users){
            System.out.println(user);
        }

    }

    @Test
    public void testDeleteUserById(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        mapper.deleteUserById("4,6");

    }

    @Test
    public void testGetUserListByTable(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        List<user>users = mapper.getUserListByTable("t_user");
        for(user user:users){
            System.out.println(user);
        }

    }


}
