/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.zk.curator;

import com.leongongye.javainpractice.javademos.utils.ThreadUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author leon
 * @version $Id: ZkTest.java, v 0.1 2017-11-28 17:03:58 leon Exp $
 */
public class ZkTest extends ZkConfig {
    public static void main(String[] args) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_SERVER, 5000, 3000, retryPolicy);
        client.getConnectionStateListenable().addListener((client12, newState) -> {
            System.out.println("client: " + client12.getZookeeperClient().getCurrentConnectionString());
            System.out.println("newState: " + newState);
        });

        client.start();
        System.out.println("started.");
        try {
            //client.create().forPath("/jlpath", "hahaha222".getBytes());
            //client.create().withMode(CreateMode.EPHEMERAL).forPath("/jlpath", "hahaha222".getBytes());
            //client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/jlpath", "hahaha222".getBytes());
            //byte[] d = client.getData().forPath("/abc");
            //String s = new String(d);
            //System.out.println(s);

            //
            BackgroundCallback callback = (client1, event) -> {
                System.out.println("=============");
                System.out.println(event.getName());
                System.out.println("=============");

            };
            client.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).inBackground(
                    callback).forPath("/jlpath", "hahaha222".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

        ThreadUtils.sleep(10000000);

        client.close();
    }
}
