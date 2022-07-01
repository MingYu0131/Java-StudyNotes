package com.JavaStudy.HspMiddleJavaTest.Network_.homework;

import com.JavaStudy.HspMiddleJavaTest.Network_.UpLoad.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author mingyu
 * @version 1.0
 * 1、使用字符流的方式，编写一个客户端程序和服务端程序
 * 2、客户端发送“name”，服务器接收到后，返回“我是nova”
 * 3、客户端发送“hobby”，服务器接收到后，返回“编写java程序”
 * 4、不是这两个问题，回复“你说啥呢”
 */
public class homework01Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server端创建成功，等待连接中");
        Socket socket = serverSocket.accept();
        //从流中获取消息，使用转换流使用字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String mes = br.readLine();
        System.out.println("Server收到消息：" + mes);
        String repeat;
        if (mes.equals("name")) {
            repeat = "我是nova";
        } else if (mes.equals("hobby")) {
            repeat = "编写java程序";
        } else {
            repeat = "你说啥呢";
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(repeat);
        bw.newLine();
        bw.flush();
        System.out.println("Server回复：" + repeat);

        //关闭资源
        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("任务完成，server关闭");

    }
}
