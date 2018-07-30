/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author leon
 * @version $Id: ReflectTest.java, v 0.1 2017年4月12日 上午11:23:28 leon Exp $
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {

        PrivateTest pt = new PrivateTest();

        Class<?> clazz = PrivateTest.class;

        Field field = clazz.getDeclaredField("name");

        field.setAccessible(true);// 这一句的作用是本来在默认  
        // 情况下是不能访问私有成员变量的，但是通过这句话把访问权限控制给压制住了。  

        field.set(pt, "456");

        System.out.println(pt.getName());
    }
}
