package com.xx.spring.core.example.controller;

import com.xx.entity.UserInfo;
import com.xx.spring.core.example.config.BeanConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */public class UserControllerTest {

     private Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
    @Test
    public void add1() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        applicationContext.getEnvironment().setActiveProfiles("production");
        applicationContext.refresh();
        UserController userController = (UserController) applicationContext.getBean("userController");
        UserInfo zhangsan = new UserInfo();
        zhangsan.setName("张三");
        userController.add(zhangsan);
    }

    @Test
    public void add2() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserController userController = (UserController) applicationContext.getBean("userController");
        UserInfo zhangsan = new UserInfo();
        zhangsan.setName("李四");
        userController.add(zhangsan);
    }

    @Test
    public void env() throws Exception {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        boolean containsuser = applicationContext.getEnvironment().containsProperty("JAVA_HOME");
        String javaHome = applicationContext.getEnvironment().getProperty("jdbc.url");
        logger.info("contains : " + containsuser);
        logger.info("JAVA_HOME : " + javaHome);
    }

}