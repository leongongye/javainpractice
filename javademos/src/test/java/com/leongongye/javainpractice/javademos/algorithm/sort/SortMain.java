/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.algorithm.sort;

import com.leongongye.javainpractice.javademos.utils.ArrayUtils;

/**
 * @author leon
 * @date 2021-03-10 21:25:34
 * @version $ Id: SortMain.java, v 0.1  leon Exp $
 */
public class SortMain {
    public static void main(String[] args) {

        int[] a = ArrayUtils.genRandomArray(0, 100);
        //int[] a = new int[] {7, 23, 61, 92, 97, 84, 32, 72, 21, 87};

        AbstractSorter ss = new SelectSorter();
        ss.sort(a);

        AbstractSorter ss2 = new SelectSorterMoveOnce();
        ss2.sort(a);

        AbstractSorter s3 = new BubbleSorter();
        s3.sort(a);

    }

    public static int[] genArray(int size, int max) {
        int[] r = new int[size];
        for (int i = 0; i < size; i++) {
            r[i] = (int) (Math.random() * max);
        }
        return r;
    }
}
