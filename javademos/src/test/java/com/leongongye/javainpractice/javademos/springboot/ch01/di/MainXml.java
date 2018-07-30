/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author leon
 * @version $Id: Main.java, v 0.1 2016年8月27日 下午2:46:14 leon Exp $
 */
public class MainXml {
    private static final Logger logger = LoggerFactory.getLogger(MainXml.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml-beans.xml");

        UseFunctionService useFunctionService = (UseFunctionService) context.getBean("useFunctionService");
        logger.info(useFunctionService.sayHello("Jialan"));
        context.close();

    }
}
