/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author leon
 * @version $Id: SubnetUtils.java, v 0.1 2016年9月22日 上午10:38:51 leon Exp $
 */
public class SubnetUtils {

    public static final String  IP_ADDRESS     = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
    public static final Pattern addressPattern = Pattern.compile(IP_ADDRESS);

    /*
     * Convert a dotted decimal format address to a packed integer format
     */
    public static int toInteger(String address) {
        Matcher matcher = addressPattern.matcher(address);
        if (matcher.matches()) {
            return matchAddress(matcher);
        } else {
            throw new IllegalArgumentException("Could not parse [" + address + "]");
        }
    }

    /* --------------------public------------------- */
    /* --------------------------------------------- */
    /* --------------------private------------------ */
    private static int matchAddress(Matcher matcher) {
        int addr = 0;
        for (int i = 1; i <= 4; ++i) {
            int n = (rangeCheck(Integer.parseInt(matcher.group(i)), 0, 255));
            addr |= ((n & 0xff) << 8 * (4 - i));
        }
        return addr;
    }

    private static int rangeCheck(int value, int begin, int end) {
        if (value >= begin && value <= end) { // (begin,end]
            return value;
        }

        throw new IllegalArgumentException("Value [" + value + "] not in range [" + begin + "," + end + "]");
    }

}
