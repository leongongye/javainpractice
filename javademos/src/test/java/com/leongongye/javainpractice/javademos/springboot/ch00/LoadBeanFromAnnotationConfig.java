/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch00;

import com.leongongye.javainpractice.javademos.springboot.ch00.config.AlarmServiceConfig;
import com.leongongye.javainpractice.javademos.springboot.service.AlarmService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * demo configuration
 *
 * @author leon
 * @version $Id: LoadBeanFromAnnotationConfig.java, v 0.1 2018-03-22 10:37:06 leon Exp $
 */
public class LoadBeanFromAnnotationConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AlarmServiceConfig.class);
        AlarmService alarmService = (AlarmService) context.getBean("alarmService");
        alarmService.alarm();
        context.close();
    }
}
