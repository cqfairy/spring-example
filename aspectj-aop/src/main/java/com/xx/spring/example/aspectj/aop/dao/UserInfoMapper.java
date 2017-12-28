package com.xx.spring.example.aspectj.aop.dao;


import com.xx.common.entity.UserInfo;

public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectById(int id);

    UserInfo selectById2(int id);
}