/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch00;

import com.leongongye.javainpractice.javademos.springboot.service.AlarmService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author leon
 * @version $Id: LoadBeanFromXml.java, v 0.1 2018-03-22 10:32:58 leon Exp $
 */
public class LoadBeanFromXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ch00/basic-beans.xml");
        //AlarmService alarmService = (AlarmService) context.getBean("alarmService");
        AlarmService alarmService = context.getBean(AlarmService.class);
        alarmService.alarm();
        context.close();
    }
}
