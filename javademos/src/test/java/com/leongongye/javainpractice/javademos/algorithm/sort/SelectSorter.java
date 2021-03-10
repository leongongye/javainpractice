/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.algorithm.sort;

/**
 * @author leon
 * @date 2021-03-10 21:16:24
 * @version $ Id: SelectSort.java, v 0.1  leon Exp $
 */
public class SelectSorter extends AbstractSorter {

    @Override
    public void doSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Start select position: " + i);
            for (int j = i + 1; j < a.length; j++) {
                if (this.less(a[j], a[i])) {
                    this.switchArrayEle(a, i, j);
                    this.printArray(a);
                }
            }
        }
    }

}
