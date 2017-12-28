/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.core.example.config;

import com.xx.spring.core.example.controller.UserController;
import com.xx.spring.core.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * [概 要] Java配置spring容器 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
@Configuration
@PropertySource("classpath:config/jdbc.properties")
public class BeanConfiguration {

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public UserController userController(){
        return new UserController();
    }

}
