/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.typesafeconfig;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValue;

/**
 *
 * @author leon
 * @version $Id: MainTests.java, v 0.1 2016年6月28日 下午4:08:32 leon Exp $
 */
public class TypesafeTests {
    public static void main(String[] args) {

        for (String a : args) {
            System.out.println(a);
        }

        //        Config c = ConfigFactory.load("bbb.conf");
        Config c = ConfigFactory.load("typesafeconfig/myconfig.conf");
        //        System.out.println(c.getConfig("cmdtest"));
        //        Config c2 = ConfigFactory.parseFile(new File("./src/main/resources/myconfig.conf"));
        System.out.println(c.getConfig("simple-lib").getString("foo"));
        for (ConfigValue o : c.getList("testlist")) {
            System.out.println(o.unwrapped());
        }
        //        System.out.println(c);
        //        System.out.println(c2);
        //        System.out.println(c.getConfig("simple-lib").getString("foo"));
        //        System.out.println(c.getString("simple-lib.foo"));
        //        System.out.println(c.getConfig("simple-app").getInt("answer"));
    }
}
