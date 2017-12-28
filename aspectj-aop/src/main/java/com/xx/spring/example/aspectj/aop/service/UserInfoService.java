/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.example.aspectj.aop.service;

import com.xx.common.entity.UserInfo;
import com.xx.spring.example.aspectj.aop.controller.UserInfoController;
import com.xx.spring.example.aspectj.aop.dao.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * [概 要] 描述类 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
@Service
public class UserInfoService {

    private Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    private UserInfoMapper userInfoMapper;

    public void addUsers(List<UserInfo> userInfos){
        logger.info("start UserInfoService.addUsers");
//        ((UserInfoService)AopContext.currentProxy()).addUsers2(userInfos);
        addUsers2(userInfos);
        logger.info("end UserInfoService.addUsers");
    }

    public void addUsers2(List<UserInfo> userInfos){
        logger.info("start UserInfoService.addUsers 2");
        int userInfosSize = userInfos.size();
        for (int i = 0 ; i < userInfosSize ; i ++){
            //userInfoMapper.insert(userInfos.get(i));
        }
        logger.info("end UserInfoService.addUsers 2");
    }

    public static void main(String[] args) {
        ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
        UserInfoController userInfoController = (UserInfoController)context.getBean("userInfoController");
        UserInfoService userInfoService = (UserInfoService)context.getBean("userInfoService");
        boolean isJDKProxy = AopUtils.isJdkDynamicProxy(userInfoService);
        boolean isAopProxy = AopUtils.isAopProxy(userInfoService);
        boolean isCglibProxy = AopUtils.isCglibProxy(userInfoService);
        System.out.println("isJDKProxy:" + isJDKProxy);
        System.out.println("isAopProxy:" + isAopProxy);
        System.out.println("isCglibProxy:" + isCglibProxy);
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
