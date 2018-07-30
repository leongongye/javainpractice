/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;

/**
 *
 * @author leon
 * @version $Id: TestBellNotify.java, v 0.1 2016年6月6日 下午10:46:12 leon Exp $
 */
public class TestBellNotify {
    //Create the logger
    public static void main(String[] args) {
        Object bell = new Object();

        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (bell) {
                            bell.wait();
                            System.out.println(1111);
                        }
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        th1.start();
        ThreadUtils.sleep(1000);

        while (true) {
            synchronized (bell) {
                bell.notify();
                System.out.println("bell notified.");
            }
            ThreadUtils.sleep(2000);
        }

    }

}
