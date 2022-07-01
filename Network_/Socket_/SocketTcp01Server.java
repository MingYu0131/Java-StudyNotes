package com.JavaStudy.HspMiddleJavaTest.Network_.Socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author mingyu
 * @version 1.0
 * 介绍Socket（套接字）编程
 * 1、通信的两端都要有Socket，是两台机器之间通信的端点
 * 2、网络通信其实就是Socket之间的通信
 * 3、Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输
 * 4、一般主动发起通信的应用程序属于客户端，等待通信请求的为服务端
 * 案例：作为服务端使用9999端口和客户端通信，接受客户端发送的消息并打印在屏幕上，并给客户端发送消息
 */
public class SocketTcp01Server {
    public static void main(String[] args) throws IOException {
        //1. 在本机 的 9999 端口监听, 等待连接
        // 细节: 要求在本机没有其它服务在监听 9999
        // 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("创建服务端Socket");
        //等待连接，如果没有连接会阻塞
        Socket socket = serverSocket.accept();
        //获取从网络连接中得到的流
        InputStream is = socket.getInputStream();
        //定义字节流读取需要使用的字符数组
        byte[] bytes = new byte[1024];
        //每次读取的字节数，为-1时结束读取
        int readInt = 0;

        while ((readInt = is.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, readInt));
        }

        OutputStream os = socket.getOutputStream();
        os.write("hello,client".getBytes(StandardCharsets.UTF_8));
        //注意一定要socket声明结束，不然对方不知道是否结束会一直等待
        //写了这句就不用写os.close了，因为这句相当于把流关闭了
        socket.shutdownOutput();
        is.close();
        socket.close();
        System.out.println("服务端退出");
    }
}
