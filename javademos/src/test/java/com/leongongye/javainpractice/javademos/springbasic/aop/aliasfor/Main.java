/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.springbasic.aop.aliasfor;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @author leon
 * @version $Id: Main.java, v 0.1 2018-07-20 16:16:30 leon Exp $
 */
@MyAnnotation("abc")
public class Main {

    @Test
    public void test() throws Exception {
        MyAnnotation a1 = getClass().getAnnotation(MyAnnotation.class);
        System.out.printf("NOT works! value=%s, name=%s\n", a1.value(), a1.name());
        // 必须使用 AnnotationUtils 才能使 AliasFor生效
        MyAnnotation a2 = AnnotationUtils.findAnnotation(getClass(), MyAnnotation.class);
        System.out.printf("Works! value=%s, name=%s\n", a2.value(), a2.name());
    }
}
