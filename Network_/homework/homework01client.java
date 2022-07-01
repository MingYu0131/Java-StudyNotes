package com.JavaStudy.HspMiddleJavaTest.Network_.homework;

import com.JavaStudy.HspMiddleJavaTest.Network_.UpLoad.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author mingyu
 * @version 1.0
 *  * 1、使用字符流的方式，编写一个客户端程序和服务端程序
 *  * 2、客户端发送“name”，服务器接收到后，返回“我是nova”
 *  * 3、客户端发送“hobby”，服务器接收到后，返回“编写java程序”
 *  * 4、不是这两个问题，回复“你说啥呢”
 */
public class homework01client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("192.168.124.2"), 9999);
        System.out.println("创建client socket完成");
        System.out.println("请输入要发送给server的消息：");
        Scanner scanner = new Scanner(System.in);
        String mes = scanner.next();
        //发送mes至流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(mes);
        //使用newLine作为结束标记，对面就只能使用readLine了
        bw.newLine();
        //注意刷新后才真正写入流
        bw.flush();
        System.out.println("Client发送消息："+mes);
        //记得标记结束

        //阅读server回复的消息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String repeat = br.readLine();
        System.out.println("收到server的回复："+repeat);

        //关闭资源
        br.close();
        bw.close();
        socket.close();
        System.out.println("Client端退出");
    }
}
