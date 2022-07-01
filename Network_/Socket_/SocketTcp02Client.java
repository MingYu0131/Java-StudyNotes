package com.JavaStudy.HspMiddleJavaTest.Network_.Socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author mingyu
 * @version 1.0
 * 要求使用字符流（使用转换流将字节流转为字符流）完成01的内容
 * 注意：其实Client的socket也会开启一个端口用于发送数据，端口号由TCP协议随机选择，具体可以通过netstat命令查询
 */
public class SocketTcp02Client {
    public static void main(String[] args) throws IOException {
        //因为是同一主机，Socket（）构造器第一个参数主机域名，可以直接填本主机
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("创建客户端socket");
        bw.write("hello Server 字符流");
        //使用bw.newLine()可以和socket.shutdownOutput();起到同样的作为，标识结束
        //注意使用这种方式声明结束，对方就只能使用readLine读取了，因为newLine会引入换行符其他的读不了
//        bw.newLine();
        //注意bufferedWriter要flush才能写入数据
        bw.flush();
        //此时就不用socket声明结束了
        socket.shutdownOutput();


        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        //注意关流的一个原则：后开启的流先关闭
        br.close();
        //bw是否需要close？其实不需要，因为socket.shutdownOutput()就相当于关流了
//        bw.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
