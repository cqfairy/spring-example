/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.example.aop.service;

import com.xx.entity.UserInfo;
import com.xx.spring.example.aop.controller.UserInfoController;
import com.xx.spring.example.aop.dao.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

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
        ((UserInfoService)AopContext.currentProxy()).addUsers2(userInfos);
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

}
