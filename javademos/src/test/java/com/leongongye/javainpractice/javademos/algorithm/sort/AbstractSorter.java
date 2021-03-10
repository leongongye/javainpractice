/*
 * Zenlayer.com Inc.
 * Copyright (c) 2014-2021 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.algorithm.sort;

import java.util.Arrays;

/**
 * @author leon
 * @date 2021-03-10 21:13:11
 * @version $ Id: SortAbstract.java, v 0.1  leon Exp $
 */
public abstract class AbstractSorter {

    private String name;
    private int    switchTimes  = 0;
    private int    compareTimes = 0;

    public AbstractSorter() {
        this.name = this.getClass().getSimpleName();
    }

    public abstract void doSort(int[] a);

    public void sort(int[] o) {
        int[] a = copyArray(o);

        print("***** Start: " + this.name);
        print("Original array: " + Arrays.toString(a));
        doSort(a);
        print("Result array: " + Arrays.toString(a));
        this.statistics();
        print("***** End: " + this.name);
    }

    public int[] copyArray(int[] a) {
        return Arrays.copyOf(a, a.length);
    }

    public void switchArrayEle(int[] a, int x, int y) {
        if (x == y) {
            return;
        }

        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
        switchTimes++;
    }

    public boolean less(int a, int b) {
        compareTimes++;
        return a < b;
    }

    public boolean larger(int a, int b) {
        compareTimes++;
        return a > b;
    }

    public void statistics() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Sorter{" + "name='" + name + '\'' + ", switchTimes=" + switchTimes + ", compareTimes=" + compareTimes + '}';
    }

    public void printArray(int[] a) {
        print(Arrays.toString(a));
    }

    public void print(String s) {
        System.out.println(s);
    }

}
