/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.collection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leon
 * @version $Id: ListRemoveIf.java, v 0.1 2016年9月29日 上午11:55:15 leon Exp $
 */
public class ListRemoveIf {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
            }
        };
        System.out.println(l);
        l.removeIf(i -> i < 3 || i > 5);
        System.out.println(l);
    }
}
