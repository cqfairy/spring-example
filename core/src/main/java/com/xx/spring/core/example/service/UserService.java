/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.core.example.service;

import com.xx.common.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * [概 要] 描述类 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean save(UserInfo userInfo){
        logger.info("save:" + userInfo);
        return true;
    }
}
