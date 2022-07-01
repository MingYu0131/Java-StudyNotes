package com.JavaStudy.HspMiddleJavaTest.Network_.homework;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author mingyu
 * @version 1.0
 * 1、使用UDP
 * 2、接收端在8888端口等待接收数据
 * 3、发送端向接收端发送数据“四大名著是哪些”
 * 4、接收端收到问题后，返回“红楼梦，西游记，水浒传，三国演义”，否则返回“what？”
 */
public class homework02Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(9999);
        System.out.println("发送发初始化完毕，即将发送消息");
        byte[] data = new byte[1024];
        System.out.println("输入要发送的消息：");
        String mes = new Scanner(System.in).next();
        data = mes.getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.124.2"), 8888);
        ds.send(dp);
        System.out.println("已发送消息："+mes);

        //接下来发送发阅读接收方回复的消息
        String repeat;
        data = new byte[1024];
        //注意：发送和接收使用的DatagramPacket()构造方法的参数不同
        dp = new DatagramPacket(data, data.length);
        ds.receive(dp);
        int len = dp.getLength();
        //注意：这里建立String要使用实际接收到的消息长度，不能使用字节数组的长度
        repeat = new String(data, 0, len);
        System.out.println("接收到回复:" + repeat);

        //退出
        ds.close();
        System.out.println("发送端退出");
    }
}
