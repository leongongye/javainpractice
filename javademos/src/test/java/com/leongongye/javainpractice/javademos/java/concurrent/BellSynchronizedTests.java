/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;

/**
 *
 * @author leon
 * @version $Id: BellSynchronizedTests.java, v 0.1 2017年8月12日 下午12:04:33 leon Exp $
 */
public class BellSynchronizedTests {

    public static void main(String[] args) {
        Object bell = new Object();
        Object bell2 = new Object();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (bell) {
                    System.out.println("11111");
                    ThreadUtils.sleep(1000);
                    System.out.println("aaaaa");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (bell) {
                    System.out.println("22222");
                    ThreadUtils.sleep(1000);
                    System.out.println("bbbbb");
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (bell2) {
                    System.out.println("33333");
                    ThreadUtils.sleep(1000);
                    System.out.println("ccccc");
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        ThreadUtils.sleep(10000000);

    }

}
