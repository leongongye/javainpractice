/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author leon
 * @version $Id: MultiThreadsAndGetResult.java, v 0.1 2016年8月5日 下午3:38:18 leon Exp $
 */
public class MultiThreadsAndGetResult {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Map<Integer, Future<Boolean>> futures = new HashMap<>();

        long t1 = System.currentTimeMillis();
        try {
            for (int i = 0; i < 20; i++) {
                final Integer j = new Integer(i);
                Future<Boolean> f = executor.submit(new Callable<Boolean>() {

                    @Override
                    public Boolean call() throws Exception {
                        System.out.println(1111);
                        ThreadUtils.sleep(1000);

                        return j % 2 == 0;
                    }

                });
                futures.put(j, f);
            }
        } finally {
            executor.shutdown();
        }

        System.out.println("getting results");

        for (Integer k : futures.keySet()) {
            try {
                System.out.println(k + " - " + futures.get(k).get());
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("Start:" + t1 + ", End:" + t2);
        System.out.println("Duration:" + (t2 - t1));
    }
}
