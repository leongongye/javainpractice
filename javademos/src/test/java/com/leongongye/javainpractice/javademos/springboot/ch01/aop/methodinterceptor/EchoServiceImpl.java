/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop.methodinterceptor;

/**
 * @author leon
 * @version $Id: EchoServiceImpl.java, v 0.1 2018-03-09 13:56:08 leon Exp $
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public void echo(String str) {
        System.out.println(str);
    }

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
