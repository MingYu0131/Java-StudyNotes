package com.JavaStudy.HspMiddleJavaTest.Network_.UDP_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author mingyu
 * @version 1.0
 *  * 案例：1、编写一个接收端A，和一个发送端B
 *  * 2、接收端A在9999端口等待数据接收（receive）
 *  * 3、发送端B向A发送数据“hello,明天吃火锅~”
 *  * 4、接收端A接收到B发送的消息，恢复“好的，明天见”，再退出
 *  * 5、发送端接收回复的数据，再退出
 *  * UDP细节：1、没有明确的服务端和客户端，演变成数据的发送端和接收端
 *  * 2、UDP网络编程主要用到两种类，接收数据和发送数据是通过DatagramSocket完成
 *  * 3、将数据封装到DatagramPacket对象（装包）
 *  * 4、当接收到DatagramPacket对象，需要进行拆包，取出数据
 *  * 5、DatagramSocket可以指定在哪个端口接收和发送数据（发送和接收方对等）
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(9998);
        System.out.println("创建UDP发送端成功");
        String mes = "hello, 明天吃火锅~~";
        byte[] data = mes.getBytes();
        //说明: 封装的 DatagramPacket 对象 data (内容字节数组 , data.length , 主机(IP) , 端口)
        DatagramPacket dp =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        ds.send(dp);

        byte[] rev = new byte[1024];
        dp = new DatagramPacket(rev, rev.length);
        ds.receive(dp);
        //获取实际的接收消息长度
        int len = dp.getLength();
        System.out.println("发送方收到消息：" + new String(rev, 0, len));
        System.out.println("发送完毕，发送端退出");
        ds.close();
    }
}
