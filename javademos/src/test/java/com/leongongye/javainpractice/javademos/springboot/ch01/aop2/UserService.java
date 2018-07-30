/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.aop2;

import java.util.List;

/**
 * @author leon
 * @version $Id: UserService.java, v 0.1 2018-03-23 11:26:01 leon Exp $
 */
public interface UserService {

    void addUser(String username);

    void deleteUser(String username);

    void deleteUserBatch(List<String> usernameList);

    void changeUserPassword(String username, String passwordRaw);

}
