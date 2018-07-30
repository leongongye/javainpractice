/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author leon
 * @version $Id: Action.java, v 0.1 2016年8月27日 下午2:56:15 leon Exp $
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) //TODO: ?
@Documented //TODO: ?
public @interface Action {
    String value() default "";
}
