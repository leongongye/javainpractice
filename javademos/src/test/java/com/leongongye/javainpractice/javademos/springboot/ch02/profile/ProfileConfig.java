/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch02.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author leon
 * @version $Id: ProfileConfig.java, v 0.1 2016年8月30日 下午5:02:17 leon Exp $
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean() {
        return new DemoBean("devdev");
    }

    @Bean
    @Profile({"prod", "test"})
    public DemoBean prodDemoBean() {
        return new DemoBean("prod");
    }

}
