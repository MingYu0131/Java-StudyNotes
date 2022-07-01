package com.JavaStudy.HspMiddleJavaTest.Network_.homework;

import com.JavaStudy.HspMiddleJavaTest.Network_.UpLoad.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mingyu
 * @version 1.0
 * 1、客户端可以输入一个音乐的文件名，比如：高山流水，服务端收到音乐名后，可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐
 * 2、客户端收到该文件后，保存到本地e:\\
 * 3、提示：该程序可以使用StreamUtils
 */
public class homework03Server {
    public static void main(String[] args) throws Exception {
        //1、初始化
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("音乐服务器初始化完毕，等待用户端连接");
        Socket socket = serverSocket.accept();
        //2、接收消息
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String musicName = br.readLine();
        System.out.println("接收到消息：" + musicName);
        //3、将文件发送给客户端
        if (musicName.equals("高山流水")) {
            InputStream is = new FileInputStream("src\\高山流水.mp3");
            byte[] music = StreamUtils.streamToByteArray(is);
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            bos.write(music);
            socket.shutdownOutput();
            bos.close();
            is.close();
        } else {//发送默认音乐111
            InputStream is = new FileInputStream("src\\111.wav");
            byte[] music = StreamUtils.streamToByteArray(is);
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            bos.write(music);
            socket.shutdownOutput();
            bos.close();
            is.close();
        }
        System.out.println("文件发送完毕");

        //4、关闭资源
        br.close();
        socket.close();
        serverSocket.close();
    }
}
