/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * @author leon
 * @version $Id: ThreadPoolTaskExecutorTests.java, v 0.1 2016年4月18日 上午10:19:46 leon Exp $
 */
public class ThreadPoolTaskExecutorTests {
    public static void main(String[] args) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        //        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(100);
        executor.initialize();

        executor.execute(new TestThreadPoolTaskExecutorRunnable("1111111"));
        executor.execute(new TestThreadPoolTaskExecutorRunnable("22222222222"));

    }
}

class TestThreadPoolTaskExecutorRunnable implements Runnable {
    private String name;

    /**
     * 
     */
    public TestThreadPoolTaskExecutorRunnable(String name) {
        this.name = name;
    }

    /** 
     * @see Runnable#run()
     */
    @Override
    public void run() {
        System.out.println(name);
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
