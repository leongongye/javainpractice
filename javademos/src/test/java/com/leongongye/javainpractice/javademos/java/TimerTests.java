/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author leon
 * @version $Id: TimerTests.java, v 0.1 2016年5月29日 上午1:44:23 leon Exp $
 */
public class TimerTests {
    public static void main(String[] args) {
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println(111111111);
            }
        }, 2000);

        System.out.println(222);
        ThreadUtils.sleep(5000);
    }
}
