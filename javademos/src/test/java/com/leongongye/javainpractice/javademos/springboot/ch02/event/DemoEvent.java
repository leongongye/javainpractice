/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch02.event;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author leon
 * @version $Id: DemoEvent.java, v 0.1 2016年8月31日 下午2:43:22 leon Exp $
 */
public class DemoEvent extends ApplicationEvent {

    /**  */
    private static final long serialVersionUID = 6085257336266872947L;
    private String msg;

    /**
     * @param source
     */
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
