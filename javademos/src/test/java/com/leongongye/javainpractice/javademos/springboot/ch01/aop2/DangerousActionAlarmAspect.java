/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author leon
 * @version $Id: DangerousActionAlarmAspect.java, v 0.1 2018-03-23 11:32:30 leon Exp $
 */
@Aspect
@Component
public class DangerousActionAlarmAspect {

    @Around("@annotation(dangerousActionAnno)")
    public Object aroundAnnotationDangerousMethods(ProceedingJoinPoint joinPoint, DangerousAction dangerousActionAnno) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //Action action = method.getAnnotation(Action.class);
        long start = System.currentTimeMillis();

        System.out.println(
                "----- aroundAnnotationDangerousMethods切面执行, 开始执行危险动作：" + dangerousActionAnno.value() + ", methodName=" + method.getName()
                        + ",入参=" + Arrays.toString(joinPoint.getArgs()));
        Object ret;
        try {
            ret = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(
                    "----- aroundAnnotationDangerousMethods切面执行, 结束危险动作：" + dangerousActionAnno.value() + ", 耗时(ms)=" + (end - start));
        }

        return ret;
    }

    @Before("execution(* com.gonglingjun..*.delete*(..))")
    public void beforeDangerousMethods(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println(
                "***** beforeDangerousMethods切面执行, class=" + method.getDeclaringClass() + ", method=" + method.getName() + ", args="
                        + Arrays.toString(joinPoint.getArgs()));
    }

}
