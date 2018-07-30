/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;

/**
 * 输出结果应该是：
 * <pre>
 * 111111111
 * 111111111
 * 222222222
 * 222222222
 * aaaaaaa
 * bbbbbbb
 * aaaaaaa
 * bbbbbbb
 * </pre>
 * @author leon
 * @version $Id: SynchronizedTests.java, v 0.1 2016年6月17日 上午11:59:17 leon Exp $
 */
public class SynchronizedTests {

    public static void main(String[] args) {
        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                testMethod();
                testMethod2();
            }
        });
        Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {
                testMethod();
                testMethod2();
            }
        });

        th1.start();
        th2.start();

        ThreadUtils.sleep(200000);

    }

    public static void testMethod() {
        System.out.println(111111111);
        ThreadUtils.sleep(2000);
        System.out.println(222222222);
    }

    public synchronized static void testMethod2() {
        System.out.println("aaaaaaa");
        ThreadUtils.sleep(2000);
        System.out.println("bbbbbbb");
    }
}
