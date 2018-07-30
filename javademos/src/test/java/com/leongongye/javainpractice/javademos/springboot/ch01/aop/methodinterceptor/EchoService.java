/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop.methodinterceptor;

/**
 * @author leon
 * @version $Id: EchoService.java, v 0.1 2018-03-09 13:55:34 leon Exp $
 */
public interface EchoService {
    void echo(String str);

    String hello(String name);
}
