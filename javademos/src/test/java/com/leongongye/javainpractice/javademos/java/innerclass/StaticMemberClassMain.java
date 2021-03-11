/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.innerclass;

import com.leongongye.javainpractice.javademos.java.innerclass.StaticMemberClass.StaticInner;

/**
 * @author leon
 * @date 2021-03-11 15:11:52
 * @version $ Id: StaticMemberClassMain.java, v 0.1  leon Exp $
 */
public class StaticMemberClassMain {
    public static void main(String[] args) {
        StaticMemberClass.StaticInner si = new StaticInner(); //可以直接引用
    }
}

class StaticMemberClass {

    public static class StaticInner {

    }

}