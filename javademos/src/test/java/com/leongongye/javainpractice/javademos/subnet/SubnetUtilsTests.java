/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.subnet;

import com.leongongye.javainpractice.javademos.utils.MySubnetUtils;
import com.leongongye.javainpractice.javademos.utils.SubnetUtils2;

/**
 *
 * @author leon
 * @version $Id: SubnetUtilsTests.java, v 0.1 2016年9月21日 下午9:04:37 leon Exp $
 */
public class SubnetUtilsTests {
    public static void main(String[] args) {
        splitSubnet("192.168.0.1/24");
        //        MySubnetUtils subnetUtils = new MySubnetUtils("192.168.1.1/30");
        //
        //        System.out.println(subnetUtils.getInfo());
        //        System.out.println(subnetUtils.getInfo().getHighAddress());
        //        System.out.println(subnetUtils.getInfo().getHighAddress());
        //        System.out.println(subnetUtils.getInfo().asInteger("192.168.2.1"));
        //
        //        System.out.println(subnetUtils.getInfo().isInRange(-1062731517));
        //        System.out.println(subnetUtils.getInfo().fromInteger(-1062731517));
    }

    public static void splitSubnet(String subnet) {
        MySubnetUtils mySubnetUtils = new MySubnetUtils(subnet);
        int firstIpInt = mySubnetUtils.getInfo().low();
        int lastIpInt = mySubnetUtils.getInfo().high();
        int ipInt = firstIpInt;
        while (ipInt < lastIpInt) {
            System.out.println(ipInt);
            System.out.println(SubnetUtils2.fromInteger(ipInt));
            System.out.println(mySubnetUtils.getInfo().fromInteger(ipInt));
            String sbn = mySubnetUtils.getInfo().fromInteger(ipInt) + "/30";
            MySubnetUtils m1 = new MySubnetUtils(sbn);
            System.out.println(m1.getInfo());
            ipInt = m1.getInfo().broadcast() + 1;
        }

    }
}
