package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.user;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    user getUserById(@Param("id") Integer id);

    List<user> getUserList();


    Integer getCount();

//更具id查询用户信息，return一个map
    //map 和实体类都是键值对，所以可以返回map
    //只能返回单条数据。 多条会报错
    //多条的话放list里
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    //返回所有
    @MapKey("id")//用一个map存储其他的map，用id做key
    Map<String, Object> getAllToMap();

    List<user> getUserByLike(@Param("mohu") String mohu);


    void deleteUserById(@Param("id") String id);

    List<user> getUserListByTable(@Param("table") String table);

    /**
     * 添加用户信息
     * @param users
     * @return
     * useGeneratedKeys：设置使用自增的主键
     * keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参数user对象的某个属性中
     */
    int insertUser(user users);



}
