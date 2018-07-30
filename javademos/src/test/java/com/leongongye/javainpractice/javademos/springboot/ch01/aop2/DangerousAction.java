/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author leon
 * @version $Id: DangerousAction.java, v 0.1 2018-03-23 11:40:39 leon Exp $
 */
@Target(ElementType.METHOD) // 用在方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时
@Documented // 文档工具加成
public @interface DangerousAction {
    String value();
}
