/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.utils;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *
 * @author leon
 * @version $Id: DichotomyUtils.java, v 0.1 2016年9月29日 上午11:08:51 leon Exp $
 */
public class ListSearchUtils {

    /**
     * 从一个 <i>已排序</i> 的list中，查询一个可用的值 ret，其中 min <= ret <= max
     * @param list
     * @param min
     * @param max
     * @return 失败返回0，成功返回ret，其中 min <= ret <= max
     */
    public static int findGapInSortedList(List<Integer> list, int min, int max) {

        if (CollectionUtils.isEmpty(list)) {
            return min;
        } else {
            Integer first = list.get(0);
            Integer last = list.get(list.size() - 1);
            //限定范围
            if (first < min || last > max) {
                return 0;
            }
            //限定个数
            if (list.size() >= max - min + 1) {
                return 0;
            }

            if (last < max) {
                return last + 1;
            } else {
                return findGapInSortedListFromHead(list, min, max);
            }
        }

    }

    /**
     * 从一个 <i>已排序</i> 的list中，查询一个可用的值 ret，其中 min <= ret <= max
     * @param list
     * @param min
     * @param max
     * @return 失败返回0，成功返回ret，其中 min <= ret <= max
     */
    public static long findGapInSortedList(List<Long> list, long min, long max) {

        if (CollectionUtils.isEmpty(list)) {
            return min;
        } else {
            Long first = list.get(0);
            Long last = list.get(list.size() - 1);
            //限定范围
            if (first < min || last > max) {
                return 0;
            }
            //限定个数
            if (list.size() >= max - min + 1) {
                return 0;
            }

            if (last < max) {
                return last + 1;
            } else {
                return findGapInSortedListFromHead(list, min, max);
            }
        }

    }

    /* --------------------public------------------- */
    /* --------------------------------------------- */
    /* --------------------private------------------ */
    private static long findGapInSortedListFromHead(List<Long> list, long min, long max) {
        if (list.get(0) != min) {
            return min;
        }

        // min == first < last == max
        return dichotomySearchGap(list, min, 0, list.size() - 1);
    }

    private static int findGapInSortedListFromHead(List<Integer> list, int min, int max) {
        if (list.get(0) != min) {
            return min;
        }

        // min == first < last == max
        return dichotomySearchGap(list, min, 0, list.size() - 1);
    }

    private static long dichotomySearchGap(List<Long> list, long min, int indexStart, int indexEnd) {

        if (indexStart == indexEnd) {
            return 0;
        }

        if (indexEnd - indexStart == 1) {
            Long eleStart = list.get(indexStart);
            Long eleEnd = list.get(indexEnd);

            if (eleEnd - eleStart == 1) {
                return 0;
            } else {
                return eleStart + 1;
            }
        }

        int pos = (indexStart + indexEnd) / 2;
        if (list.get(pos) == pos + min) {
            return dichotomySearchGap(list, min, pos, indexEnd);
        } else {
            return dichotomySearchGap(list, min, indexStart, pos);
        }
    }

    private static int dichotomySearchGap(List<Integer> list, int min, int indexStart, int indexEnd) {

        if (indexStart == indexEnd) {
            return 0;
        }

        if (indexEnd - indexStart == 1) {
            Integer eleStart = list.get(indexStart);
            Integer eleEnd = list.get(indexEnd);

            if (eleEnd - eleStart == 1) {
                return 0;
            } else {
                return eleStart + 1;
            }
        }

        int pos = (indexStart + indexEnd) / 2;
        if (list.get(pos) == pos + min) {
            return dichotomySearchGap(list, min, pos, indexEnd);
        } else {
            return dichotomySearchGap(list, min, indexStart, pos);
        }
    }

}
