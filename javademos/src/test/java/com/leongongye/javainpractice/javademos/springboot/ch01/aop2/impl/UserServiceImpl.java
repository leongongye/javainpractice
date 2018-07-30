/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop2.impl;

import com.leongongye.javainpractice.javademos.springboot.ch01.aop2.DangerousAction;
import com.leongongye.javainpractice.javademos.springboot.ch01.aop2.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leon
 * @version $Id: UserServiceImpl.java, v 0.1 2018-03-23 11:28:05 leon Exp $
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("user added: " + username);
    }

    @Override
    public void deleteUser(String username) {
        System.out.println("user deleted: " + username);
    }

    @Override
    public void deleteUserBatch(List<String> usernameList) {
        System.out.println("userList deleted: " + usernameList);
    }

    @Override
    @DangerousAction("明文改密码")
    public void changeUserPassword(String username, String passwordRaw) {
        System.out.println("更改用户：" + username + "，新密码为：" + passwordRaw);
    }
}
