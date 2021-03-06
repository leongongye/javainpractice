/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package com.leongongye.javainpractice.javademos.java.socket.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author leon
 * @version $Id: Client.java, v 0.1 2018-07-31 14:28:39 leon Exp $
 */
public class Client {

    static private Random r = new Random();

    public static void main(String[] args) {
        try {
            System.out.println("客户端启动！");
            //1.创建客户端Socket，指定服务器地址和端口号
            Socket socket = new Socket("127.0.0.1", 8888);
            //2.获取输出流，用来向服务器发送信息
            OutputStream os = socket.getOutputStream();//字节输出流
            //转换为打印流
            PrintWriter pw = new PrintWriter(os);

            long name = Math.abs(r.nextLong());
            long pass = Math.abs(r.nextLong());

            pw.write("用户名：" + name + "；密码：" + pass);
            pw.flush();//刷新缓存，向服务器端输出信息
            //关闭输出流
            socket.shutdownOutput();
            //3.获取输入流，用来读取服务器端的响应信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器端返回的信息是：" + info);
            }
            //4.关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
