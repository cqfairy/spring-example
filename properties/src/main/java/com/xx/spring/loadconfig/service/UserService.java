package com.xx.spring.loadconfig.service;

import com.xx.entity.UserInfo;
import com.xx.spring.loadconfig.dao.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 欣欣 on 2017/7/13.
 */
@Service("userService")
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Value("${jdbc.url}")
    private String url ;
    private String myfile ;

    @Autowired
    private UserInfoMapper userInfoMapper ;

    public UserService() {
    }

    public boolean save(){
        logger.info("url:" + url);
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
        logger.info(userInfo.toString());
        return false;
    }
}
