/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.expectit;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.connection.channel.direct.Session.Shell;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;

import java.io.IOException;
import java.security.PublicKey;

/**
 *
 * @author leon
 * @version $Id: MyExpectTests.java, v 0.1 2016年9月18日 下午7:34:58 leon Exp $
 */
public class MyExpectTests {
    public static void main(String[] args) throws IOException {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new HostKeyVerifier() {
            @Override
            public boolean verify(String s, int i, PublicKey publicKey) {
                return true;
            }
        });
        ssh.connect("myvm.gonglingjun.com");
        ssh.authPassword("root", "root");
        Session session = ssh.startSession();
        session.allocateDefaultPTY();
        Shell shell = session.startShell();

        MyExpect expect = new MyExpect(shell.getInputStream(), shell.getOutputStream());
        System.out.println("ddddd");
        System.out.println(expect.before + expect.match);
        expect.send("ls\n");
        expect.expect("$");
        System.out.println(expect.before + expect.match);
        expect.send("exit\n");
        expect.expectEOF();
        System.out.println(expect.before);
        expect.close();

    }
}
