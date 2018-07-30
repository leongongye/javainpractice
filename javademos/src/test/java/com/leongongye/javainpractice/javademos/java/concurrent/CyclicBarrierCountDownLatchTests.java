/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author leon
 * @version $Id: CyclicBarrierCountDownLatchTests.java, v 0.1 2018-03-08 15:55:56 leon Exp $
 */
public class CyclicBarrierCountDownLatchTests {

    private static int             playerNum       = 8;
    private static int             callRoomNum     = 3;//检录处
    private static CyclicBarrier   cyclicBarrier   = new CyclicBarrier(playerNum);
    private static CountDownLatch  countDownLatch  = new CountDownLatch(playerNum);
    private static Semaphore       semaphore       = new Semaphore(callRoomNum);
    private static ExecutorService executorService = Executors.newFixedThreadPool(50);

    public static void main(String args[]) {
        for (int i = 1; i < 9; i++) {
            executorService.execute(new Thread(new Runner(i, cyclicBarrier, countDownLatch, semaphore)));
        }

        try {
            countDownLatch.await();
            System.out.println("所有选手完成比赛，比赛结束。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}

class Runner implements Runnable {

    private int            number;
    private CyclicBarrier  cyclicBarrier;
    private CountDownLatch countDownLatch;
    private Semaphore      semaphore;

    public Runner(int number, CyclicBarrier cyclicBarrier, CountDownLatch countDownLatch, Semaphore semaphore) {
        this.number = number;
        this.cyclicBarrier = cyclicBarrier;
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.printf("%d选手到达检录处，开始准备\n", number);
            int timer = new Random().nextInt(3);
            TimeUnit.SECONDS.sleep(timer);
            System.out.printf("%d号选手检录完毕,检录耗时%d\n", number, timer);
            semaphore.release();
            System.out.printf("%d号选手离开检录处，准备完毕，等待比赛开始。\n", number);
            cyclicBarrier.await();
            System.out.printf("%d号选手于%s时起跑!\n", number, new Date().toString());
            int runTime = new Random().nextInt(3) + 1;
            TimeUnit.SECONDS.sleep(runTime);
            System.out.printf("%d号选手完成比赛，耗时%d秒，当前时间：%s\n", number, runTime, new Date().toString());
            countDownLatch.countDown();
            countDownLatch.await();
            System.out.printf("%d号选手比赛结束，离场\n", number);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}