/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.subnet;

import com.leongongye.javainpractice.javademos.model.Subnet;
import com.leongongye.javainpractice.javademos.utils.MySubnetUtils;
import com.leongongye.javainpractice.javademos.utils.SubnetUtils2;

/**
 *
 * @author leon
 * @version $Id: Main.java, v 0.1 2016年9月22日 上午10:34:24 leon Exp $
 */
public class SubnetTests {
    public static void main(String[] args) {
        splitSubnet("192.168.0.1/24");
        //        Subnet sn = new Subnet("192.168.0.1/30");
        //        System.out.println(sn);
    }

    public static void splitSubnet(String cidr) {
        Subnet s = new Subnet(cidr);
        System.out.println(s.broadcastLong());
        int firstIpInt = s.low();
        int lastIpInt = s.high();
        int ipInt = firstIpInt;
        int i = 1;
        while (ipInt < lastIpInt) {
            System.out.println("==" + i + "==");
            System.out.println(ipInt);
            System.out.println(SubnetUtils2.fromInteger(ipInt));
            System.out.println(s.fromInteger(ipInt));
            String sbn = s.fromInteger(ipInt) + "/30";
            MySubnetUtils m1 = new MySubnetUtils(sbn);
            System.out.println(m1.getInfo());
            ipInt = m1.getInfo().broadcast() + 1;
            i++;
        }

    }
}
