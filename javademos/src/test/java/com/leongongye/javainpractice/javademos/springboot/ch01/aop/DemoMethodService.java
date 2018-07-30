/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop;

import org.springframework.stereotype.Service;

/**
 *
 * @author leon
 * @version $Id: DemoMethodService.java, v 0.1 2016年8月27日 下午2:58:33 leon Exp $
 */
@Service
public class DemoMethodService {

    @Action("哈哈哈哈哈")
    public void add(String s) {
        System.out.println("DemoMethodService - add 方法执行 - " + s);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public void del(String s) {
        System.out.println("DemoMethodService - del 方法执行 - " + s);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

}
