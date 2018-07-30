/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.expectit;

import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static net.sf.expectit.matcher.Matchers.eof;
import static net.sf.expectit.matcher.Matchers.regexp;

/**
 *
 * @author leon
 * @version $Id: ExpectitTest.java, v 0.1 2016年9月18日 下午6:04:45 leon Exp $
 */
public class ExpectitTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("/bin/sh");

        Expect expect = new ExpectBuilder().withInputs(process.getInputStream()).withOutput(process.getOutputStream()).withTimeout(1,
                TimeUnit.SECONDS).withExceptionOnFailure().build();
        // try-with-resources is omitted for simplicity
        expect.sendLine("ls -lh");
        // capture the total
        String total = expect.expect(regexp("^total (.*)")).group(1);
        System.out.println("Size: " + total);
        // capture file list
        String list = expect.expect(regexp("\n$")).getBefore();
        // print the result
        System.out.println("List: " + list);
        expect.sendLine("exit");
        // expect the process to finish
        expect.expect(eof());
        // finally is omitted
        process.waitFor();
        expect.close();
    }
}
