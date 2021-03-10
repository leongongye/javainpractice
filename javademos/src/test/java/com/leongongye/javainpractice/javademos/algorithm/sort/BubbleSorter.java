/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.algorithm.sort;

/**
 * @author leon
 * @date 2021-03-10 21:45:35
 * @version $ Id: BubbleSorter.java, v 0.1  leon Exp $
 */
public class BubbleSorter extends AbstractSorter {
    @Override
    public void doSort(int[] a) {
        for (int j = a.length - 1; j >= 0; j--) {
            System.out.println("Start select position: " + j);
            int i = 0;
            while (i < j) {
                if (this.larger(a[i], a[i + 1])) {
                    this.switchArrayEle(a, i, i + 1);
                    this.printArray(a);
                }
                i++;
            }
        }
    }
}
