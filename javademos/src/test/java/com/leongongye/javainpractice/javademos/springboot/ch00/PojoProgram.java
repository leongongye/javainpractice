/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch00;

import com.leongongye.javainpractice.javademos.springboot.service.AlarmService;
import com.leongongye.javainpractice.javademos.springboot.service.impl.AlarmServiceImpl;
import com.leongongye.javainpractice.javademos.springboot.service.impl.BeepAlarmSoundMakerImpl;

/**
 * @author leon
 * @version $Id: PojoProgram.java, v 0.1 2018-03-22 14:14:21 leon Exp $
 */
public class PojoProgram {

    public static void main(String[] args) {

        System.out.println("Start!");
        BeepAlarmSoundMakerImpl beepAlarmSoundMakerImpl = new BeepAlarmSoundMakerImpl();
        AlarmService alarmService = new AlarmServiceImpl(beepAlarmSoundMakerImpl);
        alarmService.alarm();

        //DingDingAlarmSoundMakerImpl dingDingAlarmSoundMaker = new DingDingAlarmSoundMakerImpl();
        //AlarmService alarmService = new AlarmServiceImpl(dingDingAlarmSoundMaker);
        //alarmService.alarm();

        System.out.println("End!");

    }

}
