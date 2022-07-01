package com.JavaStudy.HspMiddleJavaTest.Network_.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author mingyu
 * @version 1.0
 * * 1、使用UDP
 * * 2、接收端在8888端口等待接收数据
 * * 3、发送端向接收端发送数据“四大名著是哪些”
 * * 4、接收端收到问题后，返回“红楼梦，西游记，水浒传，三国演义”，否则返回“what？”
 */
public class homework02Receiver {
    public static void main(String[] args) throws IOException {
        //选择在哪个端口等待
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        System.out.println("接收端UDP初始化完毕");
        byte[] data = new byte[1024];
        //初始化接收用的数据包
        DatagramPacket dp = new DatagramPacket(data, data.length);
        datagramSocket.receive(dp);
        //获取接收到的数据长度
        int len = dp.getLength();
        //获取发送方的消息，等下用于回复消息
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        String repeat;
        String mes = new String(data, 0, len);
        System.out.println("接收端收到消息：" + mes);
        if (mes.equals("四大名著是哪些")) {
            repeat = "红楼梦，西游记，水浒传，三国演义";
        } else {
            repeat = "what?";
        }
        data = repeat.getBytes();
        dp = new DatagramPacket(data, data.length, address, port);
        datagramSocket.send(dp);
        System.out.println("接收方回复消息：" + repeat);
        datagramSocket.close();
        System.out.println("接收方退出");

    }
}
