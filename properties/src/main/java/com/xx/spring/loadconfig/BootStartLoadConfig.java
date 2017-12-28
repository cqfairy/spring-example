package com.xx.spring.loadconfig;

import com.xx.spring.loadconfig.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by 欣欣 on 2017/7/13.
 */
public class BootStartLoadConfig {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.save();
    }

}
