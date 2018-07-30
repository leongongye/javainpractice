/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.objectid;

/**
 *
 * @author leon
 * @version $Id: ObjectIdTests.java, v 0.1 2016年12月16日 下午1:32:17 leon Exp $
 */
public class ObjectIdTests {
    public static void main(String[] args) {
        ObjectId oid = new ObjectId();
        System.out.println(oid.getMachineIdentifier());
        System.out.println(oid.toString());
        System.out.println(oid.toHexString());

        ObjectId objectId2 = new ObjectId(oid.toHexString());

        System.out.println(objectId2.toHexString());
        System.out.println(objectId2.getMachineIdentifier());
    }
}
