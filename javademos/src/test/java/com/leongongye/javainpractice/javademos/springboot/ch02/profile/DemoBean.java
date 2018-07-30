/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch02.profile;

/**
 *
 * @author leon
 * @version $Id: DemoBean.java, v 0.1 2016年8月30日 下午5:02:45 leon Exp $
 */
public class DemoBean {

    private String name;

    /**
     *
     */
    public DemoBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
