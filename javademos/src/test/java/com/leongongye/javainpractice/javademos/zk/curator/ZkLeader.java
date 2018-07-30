/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.zk.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatch.State;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon
 * @version $Id: ZkLeader.java, v 0.1 2017-11-29 17:59:08 leon Exp $
 */
public class ZkLeader extends ZkConfig {

    protected static     String PATH       = "/francis/leader";
    private static final int    CLIENT_QTY = 10;

    public static void main(String[] args) throws Exception {
        List<CuratorFramework> clients = new ArrayList<>();
        List<LeaderLatch> examples = new ArrayList<>();
        try {
            for (int i = 0; i < CLIENT_QTY; i++) {
                int finalI = i;
                CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_SERVER, new ExponentialBackoffRetry(20000, 3));
                clients.add(client);
                LeaderLatch latch = new LeaderLatch(client, PATH, "Client #" + finalI);

                latch.addListener(new LeaderLatchListener() {

                    @Override
                    public void isLeader() {
                        // TODO Auto-generated method stub
                        System.out.println("I am Leader, #" + finalI);
                    }

                    @Override
                    public void notLeader() {
                        // TODO Auto-generated method stub
                        System.out.println("I am not Leader, #" + finalI);
                    }
                });
                examples.add(latch);
                client.start();
                latch.start();
                //ThreadUtils.sleep(3000);
            }
            Thread.sleep(10000000);
            LeaderLatch currentLeader = null;
            for (LeaderLatch latch : examples) {
                if (latch.hasLeadership()) {
                    currentLeader = latch;
                }
            }
            System.out.println("current leader is " + currentLeader.getId());
            System.out.println("release the leader " + currentLeader.getId());
            currentLeader.close();

            Thread.sleep(5000000);

            for (LeaderLatch latch : examples) {
                if (latch.hasLeadership()) {
                    currentLeader = latch;
                }
            }
            System.out.println("current leader is " + currentLeader.getId());
            System.out.println("release the leader " + currentLeader.getId());
        } finally {
            for (LeaderLatch latch : examples) {
                if (null != latch.getState() && latch.getState() != State.CLOSED) {
                    CloseableUtils.closeQuietly(latch);
                }
            }
            for (CuratorFramework client : clients) {
                CloseableUtils.closeQuietly(client);
            }
        }
    }

}
