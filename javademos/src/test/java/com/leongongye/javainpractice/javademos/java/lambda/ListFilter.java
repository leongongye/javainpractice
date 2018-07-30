/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leon
 * @version $Id: ListFilter.java, v 0.1 2017-09-25 18:36:44 leon Exp $
 */
public class ListFilter {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        List l2 = l.stream().filter((i) -> i > 2).collect(Collectors.toList());
        System.out.println(l2);

        String s = l.stream().filter(i -> i > 1).map(n -> String.valueOf(n)).collect(Collectors.joining(","));
        System.out.println(s);

    }
}
