/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.utils;

import java.util.logging.Logger;

/**
 *
 * @author leon
 * @version $Id: ThreadUtils.java, v 0.1 2016年4月5日 下午12:59:07 leon Exp $
 */
public class ThreadUtils {

    public static void wait(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
        }
    }

    public static void sleep(long timestampStart, long timestampEnd, long interval) {
        long delta = timestampEnd - timestampStart;
        if (interval - delta > 0) {
            sleep(interval - delta);
        }
    }

    public static void sleep(long t) {
        sleep(t, null);
    }

    public static void sleep(long t, Logger logger) {
        sleep(t, logger, "Exception occurred while sleeping");
    }

    public static void sleep(long t, Logger logger, String msg) {
        try {
            Thread.sleep(t);
        } catch (Exception e) {
        }
    }

}
