/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.innerclass;

/**
 * @author leon
 * @date 2021-03-11 15:12:49
 * @version $ Id: AnonymousClass.java, v 0.1  leon Exp $
 */
public class AnonymousClass {

    public static void main(String[] args) {
        Outer outer = new Outer("Nested");
        outer.asyncHello();
    }

}

class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    void asyncHello() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, " + Outer.this.name);
            }
        };
        new Thread(r).start();
    }
}
