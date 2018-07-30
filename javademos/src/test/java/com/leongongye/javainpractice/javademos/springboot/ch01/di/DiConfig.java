/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch01.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author leon
 * @version $Id: DiConfig.java, v 0.1 2016年8月27日 下午2:45:34 leon Exp $
 */
@Configuration
//@ComponentScan("com.gonglingjun.spring.ch01.di")
public class DiConfig {

    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        return new UseFunctionService();
    }

}
