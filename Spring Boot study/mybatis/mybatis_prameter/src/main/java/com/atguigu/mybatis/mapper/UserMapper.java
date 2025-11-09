package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

//命名规则： 假设class叫user， 对应的sql表叫t_user，mapper叫UserMapper, 配置文档叫叫UserMapper.xml
//xml映射文件记得放resources里，弄完后记得在主xml(mybatis-config.xml)中添加
public interface UserMapper {
    int insertUser();

    int updateUser();

    int deleteUser();

    user getUserById();

    List<user> getUserList();

    user getUserByName(String name);

//    验证登录
    user checkLogin(String name, String pwd);


//    验证登录，（以map作为参数）
    user checkLoginByMap(Map<String, Object> map);

    void insertUserByClass(user User);

    //自己设置key

    /**
     *
     * @param username
     * @param pwd
     * @return
     */
    List<user> checkLoginByParam(@Param("username")String username, @Param("password")String pwd);




}
