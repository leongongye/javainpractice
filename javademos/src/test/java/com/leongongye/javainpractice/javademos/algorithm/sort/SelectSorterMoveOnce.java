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
public class SelectSorterMoveOnce extends AbstractSorter {

    @Override
    public void doSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Start select position: " + i);
            int targetIntex = i;
            for (int j = i + 1; j < a.length; j++) {
                //只是记录下元素下标，最后只进行一次交换
                if (this.less(a[j], a[targetIntex])) {
                    targetIntex = j;
                }
            }
            this.switchArrayEle(a, i, targetIntex);
            this.printArray(a);
        }
    }

}
