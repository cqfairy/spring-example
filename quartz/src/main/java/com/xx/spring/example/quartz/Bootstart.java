/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.example.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * [概 要] 描述类 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
public class Bootstart {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        context.start();
        System.out.println("服务提供者启动成功");
        synchronized (Bootstart.class) {
            while (true) {
                try {
                    Bootstart.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
