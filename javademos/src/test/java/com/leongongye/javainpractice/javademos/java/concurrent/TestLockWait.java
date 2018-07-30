/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author leon
 * @version $Id: TestLockWait.java, v 0.1 2016年4月6日 下午7:54:13 leon Exp $
 */
public class TestLockWait {

    public static void main(String[] args) {
        Object lock = new Object();
        Lock l1 = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("1");
                    l1.lock();
                    ThreadUtils.sleep(2000);
                    System.out.println("a");
                    //                    synchronized (lock) {
                    //                        System.out.println("1");
                    //                        lock.wait();
                    //                        System.out.println("a");
                    //                        //                        lock.notify();
                    //                    }
                } finally {
                    l1.unlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("2");
                    l1.lock();
                    ThreadUtils.sleep(2000);
                    System.out.println("b");
                    //                    synchronized (lock) {
                    //                        System.out.println("1");
                    //                        lock.wait();
                    //                        System.out.println("a");
                    //                        //                        lock.notify();
                    //                    }
                } finally {
                    l1.unlock();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("3");
                    l1.lock();
                    ThreadUtils.sleep(2000);
                    System.out.println("c");
                    //                    synchronized (lock) {
                    //                        System.out.println("1");
                    //                        lock.wait();
                    //                        System.out.println("a");
                    //                        //                        lock.notify();
                    //                    }
                } finally {
                    l1.unlock();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        //        System.out.println("zzzz");

        //        synchronized (lock) {
        //            lock.notify();
        //        }

    }

}
