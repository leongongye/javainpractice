/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.di;

import ch.qos.logback.classic.Level;
import com.leongongye.javainpractice.javademos.utils.LogbackUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author leon
 * @version $Id: Main.java, v 0.1 2016年8月27日 下午2:46:14 leon Exp $
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("Jialan"));
        context.close();

        logger.info("11111");
        logger.debug("22222");

        LogbackUtils.changeLoggerLevel("root", Level.DEBUG);

        logger.info("33333");
        logger.debug("44444");

    }
}
