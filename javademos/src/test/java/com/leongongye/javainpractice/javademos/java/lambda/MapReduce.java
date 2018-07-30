/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author leon
 * @version $Id: MapReduce.java, v 0.1 2017-09-25 18:56:52 leon Exp $
 */
public class MapReduce {
    public static void main(String[] args) {
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        System.out.println("lambda:");

        // 使用lambda表达式
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);

        // 计算总和
        Double s = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println(s);
    }
}
