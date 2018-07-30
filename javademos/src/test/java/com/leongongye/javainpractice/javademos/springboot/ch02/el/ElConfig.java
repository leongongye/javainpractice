/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springboot.ch02.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 *
 * @author leon
 * @version $Id: ElConfig.java, v 0.1 2016年8月30日 下午3:45:03 leon Exp $
 */
@Configuration
@ComponentScan("com.gonglingjun")
@PropertySource("classpath:ch02/el/test.properties")
public class ElConfig {

    @Value("common string")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;

    @Value("#{elDemoService.getAnother()}")
    private String fromAnother;

    @Value("@elDemoService.getAnother()")
    private String fromAnother2;

    @Value("classpath:ch02/el/test.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;

    @Value("${name}")
    private String personName;

    @Autowired
    private Environment environment;

    public void output() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(fromAnother2);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));

            System.out.println(personName);
            System.out.println(environment.getProperty("address"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
