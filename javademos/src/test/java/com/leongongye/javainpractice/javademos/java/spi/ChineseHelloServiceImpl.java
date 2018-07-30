/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.spi;

/**
 * @author leon
 * @version $Id: ChineseHelloServiceImpl.java, v 0.1 2018-07-30 11:13:36 leon Exp $
 */
public class ChineseHelloServiceImpl implements HelloService {

    public ChineseHelloServiceImpl() {
        System.out.println(getClass() + "constructor");
    }

    @Override
    public String sayHello() {
        return "你好！！！";
    }
}
