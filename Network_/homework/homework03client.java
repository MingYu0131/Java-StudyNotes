package com.JavaStudy.HspMiddleJavaTest.Network_.homework;

import com.JavaStudy.HspMiddleJavaTest.Network_.UpLoad.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author mingyu
 * @version 1.0
 *  * 1、客户端可以输入一个音乐的文件名，比如：高山流水，服务端收到音乐名后，可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐
 *  * 2、客户端收到该文件后，保存到本地e:\\
 *  * 3、提示：该程序可以使用StreamUtils
 */
public class homework03client {
    public static void main(String[] args) throws Exception {
        //1、初始化
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端初始化完毕，请输入想获取的音乐名：");
        String musicName = new Scanner(System.in).next();
        //2、发送音乐名
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(musicName);
        bw.newLine();
        bw.flush();
        System.out.println("Client发送："+musicName);
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //3、获取到传输过来的音乐文件
        byte[] data = StreamUtils.streamToByteArray(bis);
        System.out.println("已获取到传输过来的音乐文件");
        //4、保存传输过来的文件
        String destPath = "e:\\music.mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        bos.write(data);
        System.out.println("已经将传输过来的文件保存到e:\\");
        //5、关闭资源
        bos.close();
        bis.close();
        bw.close();
        socket.close();
        System.out.println("Client退出");
    }
}
