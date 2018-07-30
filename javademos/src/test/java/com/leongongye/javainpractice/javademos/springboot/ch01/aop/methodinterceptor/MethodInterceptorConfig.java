/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop.methodinterceptor;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;

/**
 * @author leon
 * @version $Id: MethodInterceptorConfig.java, v 0.1 2018-03-09 13:54:18 leon Exp $
 */
public class MethodInterceptorConfig {

    @Bean
    public EchoService echoService() {
        return new EchoServiceImpl();
    }

    @Bean
    public MyMethodInterceptor monitorInterceptor() {
        return new MyMethodInterceptor();
    }

    @Bean
    public YourMethodInterceptor yourMethodInterceptor() {
        return new YourMethodInterceptor();
    }

    @Bean
    public BeanNameAutoProxyCreator monitorAutoProxy() {
        BeanNameAutoProxyCreator autoProxy = new BeanNameAutoProxyCreator();
        autoProxy.setProxyTargetClass(true);// 这个属性为true时，表示被代理的是目标类本身而不是目标类的接口
        autoProxy.setBeanNames("*Service");
        autoProxy.setInterceptorNames("monitorInterceptor", "yourMethodInterceptor");
        return autoProxy;
    }
}
