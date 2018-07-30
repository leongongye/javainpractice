/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author leon
 * @version $Id: UserService.java, v 0.1 2018-04-13 15:04:23 leon Exp $
 */
public class UserService {

    private final Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();

    public String getUserNameByUserId(String userId) {
        try {
            return cache.get(userId, () -> {
                Thread.sleep(1000); // 模拟业务逻辑耗时
                return "userId" + "'s name";
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

}
