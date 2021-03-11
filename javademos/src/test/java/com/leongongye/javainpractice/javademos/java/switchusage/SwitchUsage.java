/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.switchusage;

/**
 * @author leon
 * @date 2021-03-11 15:19:44
 * @version $ Id: SwitchUsage.java, v 0.1  leon Exp $
 */
public class SwitchUsage {
    public static void main(String[] args) {

        int a = (int) (Math.random() * 10) % 2;

        switch (a) {
            case 1:
                System.out.println("111");
                break;
            case 0:
                System.out.println("000");
                break;
        }

        String s = "abc" + a;

        switch (s) {
            case "abc0":
                System.out.println("aabbcc");
                break;
            case "abc1":
                System.out.println("xxxxxx");
                break;
            default:
                System.out.println("defualt");
        }

    }
}
