/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.guava;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
 * @author leon
 * @version $Id: BasicTests.java, v 0.1 2018-04-13 15:11:14 leon Exp $
 */
public class BasicTests {

    private static final Logger logger = LoggerFactory.getLogger(BasicTests.class);

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
    }

    @Test
    public void base() throws Exception {
        logger.info("start");
        StopWatch clock = new StopWatch();
        for (int i = 0; i < 100; i++) {
            clock.start();
            userService.getUserNameByUserId("1");
            clock.stop();
            Thread.sleep(200); // 模拟处理其他业务耗时
            logger.info(" i=" + i + " userService.getUserNameByUserId 耗时:" + clock.getLastTaskTimeMillis() + "ms");
        }
    }
}
