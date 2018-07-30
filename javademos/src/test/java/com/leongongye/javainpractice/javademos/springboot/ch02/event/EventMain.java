/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch02.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author leon
 * @version $Id: EventMain.java, v 0.1 2016年8月31日 下午2:48:05 leon Exp $
 */
public class EventMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);

        demoPublisher.publish("【这里是消息内容】");
        context.close();

    }
}
