/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.example.transaction.service;

import com.xx.common.entity.UserInfo;
import com.xx.spring.example.transaction.dao.UserInfoMapper;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [概 要] 描述类 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
//@EnableAspectJAutoProxy
@Service("userInfoService")
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    public boolean saveUsers(List<UserInfo> userInfos){
//        return ((UserInfoService) AopContext.currentProxy()).saveUsers2(userInfos);
        return saveUsers2(userInfos);
    }


//    @Transactional
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public boolean saveUsers2(List<UserInfo> userInfos){
        int userInfosSize = userInfos.size();
        for (int i = 0 ; i < userInfosSize;i++){
            if(i == 1){
                throw new RuntimeException("数据异常");
            }
            userInfoMapper.insert(userInfos.get(i));
        }
        return true;
    }
}
