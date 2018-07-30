/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author leon
 * @version $Id: ListForEach.java, v 0.1 2017-09-25 18:31:13 leon Exp $
 */
public class ListForEach {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("abc", "def", "ghi");
        ls.forEach((n) -> {
            System.out.println("==" + n);
            System.out.println("++" + n);
        });
    }
}
