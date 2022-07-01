package com.JavaStudy.HspMiddleJavaTest.Network_.UpLoad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author mingyu
 * @version 1.0
 *  * 1、编写一个服务端和一个客户端
 *  * 2、服务端在8888端口监听
 *  * 3、客户端连接到服务端，发送一张图片e:\\apex.png
 *  * 4、服务器接受到客户端发送的图片，保存到src下，发送“收到图片”再退出
 *  * 5、客户端接受到服务端发送的“收到图片”，再退出
 *  * 6、要求使用工具类，StreamUtils.java
 */
public class Client01 {
    public static void main(String[] args) throws Exception {
        String filePath = "e:\\apex.png";
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("ClientSocket创建成功");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        //将图片转换成了字节数组，然后直接放到socket的流上
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        System.out.println("Client将文件上传至流");
        //注意一定要标记结束
        socket.shutdownOutput();
        //接受服务器发送来的消息
        BufferedInputStream bis2 = new BufferedInputStream(socket.getInputStream());
        String mes = StreamUtils.streamToString(bis2);
        System.out.println(mes);

        System.out.println("用户端退出");

        //关闭资源，先开启的后关闭
        bis2.close();
        bis.close();
        bos.close();
        socket.close();
    }
}
