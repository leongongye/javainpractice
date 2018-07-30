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
 * @version $Id: CanalSubnetUtils.java, v 0.1 2016年9月21日 下午9:49:47 leon Exp $
 */
public class SubnetUtils2 {
    public static final String  IP_ADDRESS     = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
    public static final String  SLASH_FORMAT   = IP_ADDRESS + "/(\\d{1,3})";
    public static final Pattern addressPattern = Pattern.compile(IP_ADDRESS);
    public static final Pattern cidrPattern    = Pattern.compile(SLASH_FORMAT);
    public static final int     NBITS          = 32;

    public static int asInteger(String address) {
        return toInteger(address);
    }

    public static int toInteger(String address) {
        Matcher matcher = addressPattern.matcher(address);
        if (matcher.matches()) {
            return matchAddress(matcher);
        } else {
            throw new IllegalArgumentException("Could not parse [" + address + "]");
        }
    }

    public static int matchAddress(Matcher matcher) {
        int addr = 0;
        for (int i = 1; i <= 4; ++i) {
            int n = (rangeCheck(Integer.parseInt(matcher.group(i)), 0, 255));
            addr |= ((n & 0xff) << 8 * (4 - i));
        }
        return addr;
    }

    public static int rangeCheck(int value, int begin, int end) {
        if (value >= begin && value <= end) { // (begin,end]
            return value;
        }

        throw new IllegalArgumentException("Value [" + value + "] not in range [" + begin + "," + end + "]");
    }

    public static String fromInteger(int val) {
        return format(toArray(val));
    }

    public static int[] toArray(int val) {
        int ret[] = new int[4];
        for (int j = 3; j >= 0; --j) {
            ret[j] |= ((val >>> 8 * (3 - j)) & (0xff));
        }
        return ret;
    }

    public static String format(int[] octets) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < octets.length; ++i) {
            str.append(octets[i]);
            if (i != octets.length - 1) {
                str.append(".");
            }
        }
        return str.toString();
    }
}
