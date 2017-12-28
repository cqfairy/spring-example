package com.xx.spring.example.transaction.service;

import com.xx.entity.UserInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
public class UserInfoServiceTest {

    private Logger logger = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @Test
    public void saveUsers() throws Exception {
        ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        UserInfoService userInfoService = (UserInfoService)context.getBean("userInfoService");
        boolean isJDKProxy = AopUtils.isJdkDynamicProxy(userInfoService);
        boolean isAopProxy = AopUtils.isAopProxy(userInfoService);
        boolean isCglibProxy = AopUtils.isCglibProxy(userInfoService);
        logger.info("isJDKProxy:" + isJDKProxy);
        logger.info("isAopProxy:" + isAopProxy);
        logger.info("isCglibProxy:" + isCglibProxy);
        List<UserInfo> userInfos = new ArrayList<>();
        UserInfo user1 = new UserInfo();
        user1.setName("张三");
        user1.setBirthday(new Date());
        user1.setSex(UserInfo.Sex.man);
        UserInfo user2 = new UserInfo();
        user2.setName("李四");
        user2.setBirthday(new Date());
        user2.setSex(UserInfo.Sex.man);
        UserInfo user3 = new UserInfo();
        user3.setName("王五");
        user3.setBirthday(new Date());
        user3.setSex(UserInfo.Sex.man);
        userInfos.add(user1);
        userInfos.add(user2);
        userInfos.add(user3);
        userInfoService.saveUsers(userInfos);

    }


}