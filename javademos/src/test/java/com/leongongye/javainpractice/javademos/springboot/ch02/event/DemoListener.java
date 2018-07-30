/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch02.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author leon
 * @version $Id: DemoListener.java, v 0.1 2016年8月31日 下午2:44:43 leon Exp $
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    /**
     * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("DemoListener 收到了发布的消息：" + msg);
    }

}
