package com.JavaStudy.HspMiddleJavaTest.Network_.Socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * @author mingyu
 * @version 1.0
 * 作为客户端，给服务端发送消息，接受服务端发送来得消息
 */
public class SocketTcp01Client {
    public static void main(String[] args) throws IOException {
        //因为是同一主机，Socket（）构造器第一个参数主机域名，可以直接填本主机
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream os = socket.getOutputStream();
        System.out.println("创建客户端socket");
        os.write("hello, server".getBytes());
        //注意socket一定要声明输出结束
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readData = 0;
        while ((readData = is.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, readData));
        }

        os.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
