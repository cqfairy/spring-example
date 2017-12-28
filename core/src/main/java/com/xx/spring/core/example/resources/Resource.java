/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.core.example.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * [概 要] 描述类 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
public class Resource {

    private Logger logger = LoggerFactory.getLogger(Resource.class);

    public void classpath() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("config/jdbc.properties");
        boolean exists = classPathResource.exists();
        logger.info("exists:" + exists);
        logger.info("description:" + classPathResource.getDescription());
        logger.info("path:" + classPathResource.getPath());
        logger.info("uri:" + classPathResource.getURI());
        logger.info("url:" + classPathResource.getURL());
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        org.springframework.core.io.Resource resource = classPathXmlApplicationContext.getResource("classpath:config/jdbc.properties");
        logger.info("exists:" + resource.exists());

    }
}
