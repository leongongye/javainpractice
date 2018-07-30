/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author leon
 * @version $Id: ListInsert.java, v 0.1 2016年8月22日 上午11:34:49 leon Exp $
 */
public class ListInsert {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        List<Integer> l2 = new ArrayList(Arrays.asList(3, 4, 5));

        l2.add(0, 200); // 会报错
        System.out.println(l);
        System.out.println(l2);
        l.add(0, 100);
        System.out.println(l);
        System.out.println(l2);
    }
}
