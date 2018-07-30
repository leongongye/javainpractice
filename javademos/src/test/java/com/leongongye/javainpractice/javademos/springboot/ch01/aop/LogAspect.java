/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
 * @author leon
 * @version $Id: LogAspect.java, v 0.1 2016年8月27日 下午2:59:00 leon Exp $
 */
@Aspect
@Component
public class LogAspect {

    //@Pointcut("@annotation(com.gonglingjun.myspringbootlearn.springboot.ch01.aop.Action)")
    //public void annotationPointCut() {
    //}
    //
    //@Around("annotationPointCut()")

    //    @Before("annotationPointCut()")
    //    public void before(JoinPoint joinPoint) {
    //        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    //        Method method = signature.getMethod();
    //        Action action = method.getAnnotation(Action.class);
    //        System.out.println("Before, 注解式拦截, action's name=" + action.name() + "methodName=" + method.getName());
    //    }
    //
    //    @After("annotationPointCut()")
    //    public void after(JoinPoint joinPoint) {
    //        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    //        Method method = signature.getMethod();
    //        Action action = method.getAnnotation(Action.class);
    //        System.out.println("After, 注解式拦截, action's name=" + action.name() + "methodName=" + method.getName());
    //    }

    //@Around("@annotation(action)")
    //public Object around(ProceedingJoinPoint joinPoint, Action action) throws Throwable {
    //    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    //    Method method = signature.getMethod();
    //    //Action action = method.getAnnotation(Action.class);
    //    long start = System.currentTimeMillis();
    //
    //    String a = "";
    //    for (Object o : joinPoint.getArgs()) {
    //        a += o + ", "; // cmd+? 案例
    //    }
    //
    //    System.out.println(
    //            "around, 注解式拦截, action's name=" + action.value() + "methodName=" + method.getName() + ",入参=" + a + ", start=" + start);
    //    Object ret;
    //    try {
    //        ret = joinPoint.proceed();
    //    } catch (Throwable e) {
    //        throw e;
    //    } finally {
    //        long end = System.currentTimeMillis();
    //        System.out.println("around, 注解式拦截, action's name=" + action.value() + "methodName=" + method.getName() + ", end=" + end);
    //        System.out.println(
    //                "around, 注解式拦截, action's name=" + action.value() + "methodName=" + method.getName() + ", duration=" + (end - start));
    //    }
    //
    //    return ret;
    //}

    //@Around("annotationPointCut()&&@annotation(action)")
    //public Object around(ProceedingJoinPoint joinPoint, Action action) throws Throwable {
    //    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    //    Method method = signature.getMethod();
    //    //Action action = method.getAnnotation(Action.class);
    //    long start = System.currentTimeMillis();
    //
    //    String a = "";
    //    for (Object o : joinPoint.getArgs()) {
    //        a += o + ", ";
    //    }
    //
    //    System.out.println(
    //            "around, 注解式拦截, action's name=" + action.name() + "methodName=" + method.getName() + ",入参=" + a + ", start=" + start);
    //    Object ret;
    //    try {
    //        ret = joinPoint.proceed();
    //    } catch (Throwable e) {
    //        throw e;
    //    } finally {
    //        long end = System.currentTimeMillis();
    //        System.out.println("around, 注解式拦截, action's name=" + action.name() + "methodName=" + method.getName() + ", end=" + end);
    //        System.out.println(
    //                "around, 注解式拦截, action's name=" + action.name() + "methodName=" + method.getName() + ", duration=" + (end - start));
    //    }
    //
    //    return ret;
    //}

    @Around("execution(* com.gonglingjun..*Service.*el(..))")
    public Object aroundM(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        long start = System.currentTimeMillis();
        System.out.println("Around，开始，methodName=" + method.getName() + ", time=" + start);
        Object ret = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Around，结束，methodName=" + method.getName() + ", time=" + end + ", takeTime=" + (end - start));
        return ret;
    }
    //
    //@Before("execution(* com.gonglingjun.spring.ch01.aop.DemoMethodService.*(..))")
    //public void beforeM(JoinPoint joinPoint) {
    //    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    //    Method method = signature.getMethod();
    //    System.out.println("Before， 方法规则式拦截，methodName=" + method.getName());
    //    start = System.currentTimeMillis();
    //}
    //
    //@After("execution(* com.gonglingjun.spring.ch01.aop.DemoMethodService.*(..))")
    //public void afterM(JoinPoint joinPoint) {
    //    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    //    Method method = signature.getMethod();
    //    System.out.println("After， 方法规则式拦截，methodName=" + method.getName());
    //    long now = System.currentTimeMillis();
    //    long duration = now - start;
    //    System.out.println("take time: " + duration);
    //}

}
