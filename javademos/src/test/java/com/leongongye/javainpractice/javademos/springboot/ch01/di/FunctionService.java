/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.di;

import org.springframework.stereotype.Service;

/**
 *
 * @author leon
 * @version $Id: FunctionService.java, v 0.1 2016年8月27日 下午2:43:11 leon Exp $
 */
@Service
public class FunctionService {
    public String sayHello(String word) {
        return "Hello " + word + "!";
    }
}
