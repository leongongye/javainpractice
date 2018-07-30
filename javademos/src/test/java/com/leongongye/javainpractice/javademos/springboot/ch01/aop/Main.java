/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author leon
 * @version $Id: Main.java, v 0.1 2016年8月27日 下午3:07:24 leon Exp $
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);

        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

        demoAnnotationService.setDemoMethodService(demoMethodService);

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                int r = demoAnnotationService.addel(3);
                System.out.println("t1 ret=" + r);

                //                demoMethodService.del("11111");
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                int r = demoAnnotationService.addel(6);
                System.out.println("t2 ret=" + r);
                //                demoMethodService.add("22222");
            }
        });

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
        }

        t2.start();

        try {
            Thread.sleep(20000000);
        } catch (InterruptedException e) {
        }

        context.close();
    }
}
