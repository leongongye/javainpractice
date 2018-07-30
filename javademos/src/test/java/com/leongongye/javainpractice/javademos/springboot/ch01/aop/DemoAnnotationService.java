/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop;

import org.springframework.stereotype.Service;

/**
 *
 * @author leon
 * @version $Id: DemoAnnotationService.java, v 0.1 2016年8月27日 下午2:57:39 leon Exp $
 */
@Service
public class DemoAnnotationService {

    private DemoMethodService demoMethodService;

    public void setDemoMethodService(DemoMethodService demoMethodService) {
        this.demoMethodService = demoMethodService;
    }

    @Action("注解式拦截的add操作")
    public int addel(int i) {
        System.out.println("DemoAnnotationService - addel 方法执行");
        try {
            Thread.sleep(i * 1000);
            //            demoMethodService.add("bbbbb");
            addel2222((i + 1));
        } catch (InterruptedException e) {
        }

        //        throw new RuntimeException("rrrrr");
        return i;
    }

    @Action("注解式拦截的add操作22222")
    public int addel2222(int i) {
        System.out.println("DemoAnnotationService - addel2222 方法执行");
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
        }
        return i;
    }

}
