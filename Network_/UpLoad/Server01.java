package com.JavaStudy.HspMiddleJavaTest.Network_.UpLoad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author mingyu
 * @version 1.0
 * 1、编写一个服务端和一个客户端
 * 2、服务端在8888端口监听
 * 3、客户端连接到服务端，发送一张图片e:\\apex.png
 * 4、服务器接受到客户端发送的图片，保存到src下，发送“收到图片”再退出
 * 5、客户端接受到服务端发送的“收到图片”，再退出
 * 6、要求使用工具类，StreamUtils.java
 */
public class Server01 {
    public static void main(String[] args) throws Exception {
        //拷贝的目标地址
        String destPath = "src/apex.png";
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("ServerSocket创建成功，等待连接");
        Socket socket = serverSocket.accept();

        byte[] bytes;

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        bytes = StreamUtils.streamToByteArray(bis);
        System.out.println("已从Client端获取到数据");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        bos.write(bytes);

        System.out.println("拷贝完成");
        //完成接受到文件后向Client发送“收到图片”
        String mes = "Server:收到图片";
        BufferedOutputStream bos2 = new BufferedOutputStream(socket.getOutputStream());
        bos2.write(mes.getBytes(StandardCharsets.UTF_8));
//        socket.shutdownOutput();
        //close()也会调用socket.shutdownOutput()？
        bos2.close();

        //关闭资源
        bos.close();
        bis.close();
        socket.close();
        serverSocket.close();
        System.out.println("Server退出");

    }
}
