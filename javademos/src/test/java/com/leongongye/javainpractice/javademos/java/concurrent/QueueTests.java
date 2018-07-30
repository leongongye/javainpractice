/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.concurrent;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author leon
 * @version $Id: QueueTests.java, v 0.1 2016年4月14日 上午10:48:54 leon Exp $
 */
public class QueueTests {
    public static void main(String[] args) {
        QueueConsumer consumer = new QueueConsumer();
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Thread producer = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Random r = new Random();
                    consumer.put(r.nextDouble() + "");
                    ThreadUtils.sleep(1000);
                }
            }
        });
        producer.start();
    }
}

class QueueConsumer implements Runnable {
    private final BlockingQueue<String> bq;

    /**
     *
     */
    public QueueConsumer() {
        bq = new LinkedBlockingQueue<>();
    }

    public void put(String msg) {
        try {
            bq.put(msg);
            System.out.println("队列中加入消息：" + msg);
        } catch (InterruptedException e) {
        }
    }

    /**
     * @see Runnable#run()
     */
    @Override
    public void run() {
        while (true) {
            try {
                String msg = bq.take();
                System.out.println("得到并消费：" + msg);
            } catch (InterruptedException e) {
            }
        }
    }
}
