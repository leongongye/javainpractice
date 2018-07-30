/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.spi;

/**
 * @author leon
 * @version $Id: EnglishHelloServiceImpl.java, v 0.1 2018-07-30 11:13:08 leon Exp $
 */
public class EnglishHelloServiceImpl implements HelloService {

    public EnglishHelloServiceImpl() {
        System.out.println(getClass() + "constructor");
    }

    @Override
    public String sayHello() {
        return "Hello!!!";
    }
}
