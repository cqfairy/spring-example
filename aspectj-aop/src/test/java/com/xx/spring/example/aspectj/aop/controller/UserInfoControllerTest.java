package com.xx.spring.example.aspectj.aop.controller;

import com.xx.common.entity.UserInfo;
import com.xx.spring.example.aspectj.aop.service.UserInfoService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */public class UserInfoControllerTest {

    private Logger logger = LoggerFactory.getLogger(UserInfoControllerTest.class);

    @Test
    public void addUsers() throws Exception {
        ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        UserInfoController userInfoController = (UserInfoController)context.getBean("userInfoController");
        UserInfoService userInfoService = (UserInfoService)context.getBean("userInfoService");
        boolean isJDKProxy = AopUtils.isJdkDynamicProxy(userInfoService);
        boolean isAopProxy = AopUtils.isAopProxy(userInfoService);
        boolean isCglibProxy = AopUtils.isCglibProxy(userInfoService);
        logger.info("isJDKProxy:" + isJDKProxy);
        logger.info("isAopProxy:" + isAopProxy);
        logger.info("isCglibProxy:" + isCglibProxy);
        List<UserInfo> userInfos = new ArrayList<>();
        UserInfo user1 = new UserInfo();
        user1.setName("一");
        user1.setBirthday(new Date());
        user1.setSex(UserInfo.Sex.man);
        UserInfo user2 = new UserInfo();
        user2.setName("二");
        user2.setBirthday(new Date());
        user2.setSex(UserInfo.Sex.man);
        UserInfo user3 = new UserInfo();
        user3.setName("三");
        user3.setBirthday(new Date());
        user3.setSex(UserInfo.Sex.man);
        userInfos.add(user1);
        userInfos.add(user2);
        userInfos.add(user3);
        userInfoController.addUsers(userInfos);
    }

}