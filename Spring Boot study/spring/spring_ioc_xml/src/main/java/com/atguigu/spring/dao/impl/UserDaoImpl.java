package com.atguigu.spring.dao.impl;

import com.atguigu.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("UserDaoImpl saveUser saved");
    }
}
