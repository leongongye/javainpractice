/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop.methodinterceptor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author leon
 * @version $Id: Main.java, v 0.1 2018-03-09 14:00:00 leon Exp $
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MethodInterceptorConfig.class);
        EchoService echoService = context.getBean(EchoService.class);
        echoService.echo("hahaha");
        System.out.println("test: " + echoService.hello("jialan"));
    }
}
