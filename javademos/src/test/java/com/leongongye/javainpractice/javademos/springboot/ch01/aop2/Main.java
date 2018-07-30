/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author leon
 * @version $Id: Main.java, v 0.1 2018-03-23 11:23:49 leon Exp $
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Aop2Configuration.class);
        UserService userService = context.getBean(UserService.class);
        userService.addUser("jialan");
        userService.deleteUser("gonglingjun");
        userService.deleteUserBatch(Arrays.asList("Han Meimei", "Li Lei"));
        userService.changeUserPassword("Michael", "23");
    }

}
