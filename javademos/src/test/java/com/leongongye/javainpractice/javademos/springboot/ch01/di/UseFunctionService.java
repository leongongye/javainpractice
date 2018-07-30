/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author leon
 * @version $Id: UseFunctionService.java, v 0.1 2016年8月27日 下午2:44:27 leon Exp $
 */
@Service
public class UseFunctionService {

    @Autowired
    private FunctionService functionService;

    public String sayHello(String word) {
        System.out.println("Use function service.");
        return functionService.sayHello(word);
    }

    /**
     * 如果xml文件中没有：
     * <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
     * 就必须定义 set 方法，才能通过setter注入自动注入
     */
    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
}
