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
 * 案例：1、编写一个接收端A，和一个发送端B
 * 2、接收端A在9999端口等待数据接收（receive）
 * 3、发送端B向A发送数据“hello,明天吃火锅~”
 * 4、接收端A接收到B发送的消息，回复“好的，明天见”，再退出
 * 5、发送端接收回复的数据，再退出
 * UDP细节：1、没有明确的服务端和客户端，演变成数据的发送端和接收端
 * 2、UDP网络编程主要用到两种类，接收数据和发送数据是通过DatagramSocket完成，数据需要封装到DatagramPacket类
 * 3、将数据封装到DatagramPacket对象（装包）
 * 4、当接收到DatagramPacket对象，需要进行拆包，取出数据
 * 5、DatagramSocket可以指定在哪个端口接收和发送数据（发送和接收方对等）
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(9999);
        //2. 构建一个 DatagramPacket 对象，准备接收数据 // 在前面讲解 UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        //只是为了接收数据，不需要指定包的目的地
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        System.out.println("UDP接收端创建成功，等待发送方发送 ");
        //3. 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        ds.receive(dp);
        int length = dp.getLength();//实际接收到的数据字节长度
        System.out.println("接收方收到消息：" + new String(buf, 0, length));

        buf = "好的，明天见".getBytes();
        //说明: 封装的 DatagramPacket 对象 data (内容字节数组 , data.length , 主机(IP) , 端口)
        dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.124.2"), 9998);
        ds.send(dp);
        System.out.println("接收方回复消息完毕");

        System.out.println("接收完毕，接收端退出");
        ds.close();
    }
}
