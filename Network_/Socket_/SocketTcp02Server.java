package com.JavaStudy.HspMiddleJavaTest.Network_.Socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author mingyu
 * @version 1.0
 * 要求使用字符流（使用转换流将字节流转为字符流）完成01的内容
 */
public class SocketTcp02Server {
    public static void main(String[] args) throws IOException {
        //1. 在本机 的 9999 端口监听, 等待连接
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("创建服务端Socket");
        //等待连接，如果没有连接会阻塞
        Socket socket = serverSocket.accept();
        //获取从网络连接中得到的流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("hello,client 字符流");
        //结束标记
        bw.newLine();
        //刷新才能写入
        bw.flush();
        System.out.println("Server发送消息成功");

        bw.close();
        br.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
