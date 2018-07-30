/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop.methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leon
 * @version $Id: MyMethodInterceptor.java, v 0.1 2018-03-09 13:53:43 leon Exp $
 */
public class YourMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Logger logger = LoggerFactory.getLogger(invocation.getMethod().getDeclaringClass());

        long start = System.currentTimeMillis();

        Object ret = invocation.proceed();

        long end = System.currentTimeMillis();
        logger.info("{} 方法耗时 {} ms (YourMethodInterceptor)", invocation.getMethod().getName(), (end - start));
        return ret;
    }
}
