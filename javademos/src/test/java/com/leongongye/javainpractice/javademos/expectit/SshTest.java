/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.expectit;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;

import java.io.IOException;
import java.util.Properties;

import static net.sf.expectit.matcher.Matchers.contains;
import static net.sf.expectit.matcher.Matchers.regexp;

/**
 *
 * @author leon
 * @version $Id: SshTest.java, v 0.1 2016年9月18日 下午6:13:46 leon Exp $
 */
public class SshTest {
    public static void main(String[] args) throws JSchException, IOException {
        JSch jSch = new JSch();
        Session session = jSch.getSession("new", "sdf.org");
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        Channel channel = session.openChannel("shell");
        channel.connect();

        Expect expect = new ExpectBuilder().withOutput(channel.getOutputStream()).withInputs(channel.getInputStream(),
                channel.getExtInputStream()).withEchoOutput(System.out).withEchoInput(System.err)
                //        .withInputFilters(removeColors(), removeNonPrintable())
                .withExceptionOnFailure().build();
        try {
            expect.expect(contains("[RETURN]"));
            expect.sendLine();
            String ipAddress = expect.expect(regexp("Trying (.*)\\.\\.\\.")).group(1);
            System.out.println("Captured IP: " + ipAddress);
            expect.expect(contains("login:"));
            expect.sendLine("new");
            expect.expect(contains("(Y/N)"));
            expect.send("N");
            expect.expect(regexp(": $"));
        } finally {
            expect.close();
            channel.disconnect();
            session.disconnect();
        }
    }
}
