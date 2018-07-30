/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.service.impl;

import com.leongongye.javainpractice.javademos.springboot.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author leon
 * @version $Id: AlarmServiceImpl.java, v 0.1 2018-03-22 17:24:02 leon Exp $
 */
public class AlarmServiceImpl2 implements AlarmService {

    @Autowired
    private BeepAlarmSoundMakerImpl beepAlarmSoundMaker;

    public AlarmServiceImpl2() {
    }

    public AlarmServiceImpl2(BeepAlarmSoundMakerImpl beepAlarmSoundMaker) {
        this.beepAlarmSoundMaker = beepAlarmSoundMaker;
    }

    public void alarm() {
        beepAlarmSoundMaker.sound();
    }

    public void setBeepAlarmSoundMaker(BeepAlarmSoundMakerImpl beepAlarmSoundMaker) {
        this.beepAlarmSoundMaker = beepAlarmSoundMaker;
    }
}
