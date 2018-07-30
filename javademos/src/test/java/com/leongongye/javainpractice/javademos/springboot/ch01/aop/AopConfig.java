/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author leon
 * @version $Id: AopConfig.java, v 0.1 2016年8月27日 下午3:06:56 leon Exp $
 */
@Configuration
@ComponentScan("com.gonglingjun.myspringbootlearn.springboot.ch01.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
