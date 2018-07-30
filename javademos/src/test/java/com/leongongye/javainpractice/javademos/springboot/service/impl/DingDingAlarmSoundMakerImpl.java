/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.service.impl;

import com.leongongye.javainpractice.javademos.springboot.service.SoundMaker;

/**
 * @author leon
 * @version $Id: DingDingAlarmSoundMakerImpl.java, v 0.1 2018-03-25 10:01:57 leon Exp $
 */
public class DingDingAlarmSoundMakerImpl implements SoundMaker {
    @Override
    public void sound() {
        System.out.println("Ding ding!!!");
    }
}
