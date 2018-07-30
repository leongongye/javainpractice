/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author leon
 * @version $Id: Main.java, v 0.1 2018-07-30 11:14:49 leon Exp $
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);
        System.out.println("Service loader complete loading.");
        Iterator<HelloService> it = serviceLoader.iterator();
        while (it.hasNext()) {
            HelloService demoService = it.next(); // constructor called
            System.out.println("class:" + demoService.getClass().getName() + "***" + demoService.sayHello());
        }

    }

}
