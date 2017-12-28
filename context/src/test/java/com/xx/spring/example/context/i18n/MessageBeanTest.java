package com.xx.spring.example.context.i18n;

import com.xx.entity.UserInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

import static org.junit.Assert.*;

/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */public class MessageBeanTest {
     @Test
     public void execute() throws Exception {
          ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");
          MessageBean messageBean = (MessageBean)applicationContext.getBean("messageBean");
          messageBean.execute();

     }

     private Logger logger = LoggerFactory.getLogger(MessageBeanTest.class);
     @Test
     public void add1() throws Exception {
          ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");
          String name = applicationContext.getMessage("name",null,"default", Locale.getDefault());
          logger.info("name:" + name);

     }

}