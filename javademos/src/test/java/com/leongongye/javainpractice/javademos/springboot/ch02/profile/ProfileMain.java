/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch02.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author leon
 * @version $Id: ProfileMain.java, v 0.1 2016年8月30日 下午5:21:48 leon Exp $
 */
public class ProfileMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getName());
        context.close();
    }
}
