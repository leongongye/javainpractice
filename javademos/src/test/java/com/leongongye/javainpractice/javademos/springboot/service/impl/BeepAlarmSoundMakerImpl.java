/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.service.impl;

import com.leongongye.javainpractice.javademos.springboot.service.SoundMaker;

/**
 * @author leon
 * @version $Id: BeepAlarmSoundMakerImpl.java, v 0.1 2018-03-22 15:00:37 leon Exp $
 */
public class BeepAlarmSoundMakerImpl implements SoundMaker {

    public void sound() {
        System.out.println("beep beep !");
    }

}
