/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch00.config;

import com.leongongye.javainpractice.javademos.springboot.service.AlarmService;
import com.leongongye.javainpractice.javademos.springboot.service.SoundMaker;
import com.leongongye.javainpractice.javademos.springboot.service.impl.AlarmServiceImpl;
import com.leongongye.javainpractice.javademos.springboot.service.impl.DingDingAlarmSoundMakerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author leon
 * @version $Id: AlarmServiceConfig.java, v 0.1 2018-03-22 15:15:32 leon Exp $
 */
@Configuration
public class AlarmServiceConfig2 {

    @Bean
    public SoundMaker soundMaker() {
        //return new BeepAlarmSoundMakerImpl();
        return new DingDingAlarmSoundMakerImpl();
    }

    @Bean
    public AlarmService alarmService() {
        return new AlarmServiceImpl();
    }
}
