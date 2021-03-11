/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java;

/**
 * @author leon
 * @date 2021-03-11 16:01:15
 * @version $ Id: StrictfpTest.java, v 0.1  leon Exp $
 */
public class StrictfpTest {
    public static void main(String[] args) {
        MyClass.test();
        MyClass2.test();
    }
}

strictfp class MyClass {
    public static void test() {
        float aFloat = 0.6710339f;
        double aDouble = 0.04150553411984792d;
        double sum = aFloat + aDouble;
        float quotient = (float) (aFloat / aDouble);
        System.out.println("float: " + aFloat);
        System.out.println("double: " + aDouble);
        System.out.println("sum: " + sum);
        System.out.println("quotient: " + quotient);
    }
}

class MyClass2 {
    public static void test() {
        float aFloat = 0.6710339f;
        double aDouble = 0.04150553411984792d;
        double sum = aFloat + aDouble;
        float quotient = (float) (aFloat / aDouble);
        System.out.println("float: " + aFloat);
        System.out.println("double: " + aDouble);
        System.out.println("sum: " + sum);
        System.out.println("quotient: " + quotient);
    }
}


