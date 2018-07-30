/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.lambda;

/**
 * @author leon
 * @version $Id: LambdaRunnable.java, v 0.1 2017-09-25 18:26:50 leon Exp $
 */
public class LambdaRunnable {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("abc");
            System.out.println("def");
        }).start();
    }

}
