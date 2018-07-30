/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.service.impl;

import com.leongongye.javainpractice.javademos.springboot.service.AlarmService;
import com.leongongye.javainpractice.javademos.springboot.service.SoundMaker;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author leon
 * @version $Id: AlarmServiceImpl.java, v 0.1 2018-03-22 17:24:02 leon Exp $
 */
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private SoundMaker soundMaker;

    public AlarmServiceImpl() {
    }

    public AlarmServiceImpl(SoundMaker soundMaker) {
        this.soundMaker = soundMaker;
    }

    public void alarm() {
        soundMaker.sound();
    }

    public void setSoundMaker(SoundMaker soundMaker) {
        this.soundMaker = soundMaker;
    }
}
