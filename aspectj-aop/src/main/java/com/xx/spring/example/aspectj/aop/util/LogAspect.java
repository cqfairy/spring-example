/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.xx.spring.example.aspectj.aop.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * [概 要] 日志通用切面 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.xx.spring.example.aspectj.aop.controller..*(..))")
    public void logPointcut(){
    }

    // 这里注解里面的值为上面的方法名
    @Before("logPointcut()")
    public void myBefore(JoinPoint joinPoint) {
        logger.info("前置通知 ： " + joinPoint.getSignature().getName());
    }

    @Around("logPointcut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("环绕通知执行方法前");
        // 手动执行目标方法
        Object obj = joinPoint.proceed();

        logger.info("环绕通知执行方法后。");
        return obj;
    }

}
