package com.JavaStudy.HspMiddleJavaTest.Network_;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author mingyu
 * @version 1.0
 * 介绍可以获取网络信息的类，InetAddress
 */
public class InetAddress_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机 InetAddress 对象 getLocalHost
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost); //根据指定主机名/域名获取 ip 地址对象 getByName
        InetAddress host2 = InetAddress.getByName("LAPTOP-JA6MS4BJ");
        System.out.println(host2); InetAddress host3 = InetAddress.getByName("www.hsp.com");
        System.out.println(host3);
        //获取 InetAddress 对象的主机名 getHostName
        String host3Name = host3.getHostName();
        System.out.println(host3Name);
        //获取 InetAddress 对象的地址 getHostAddress
        String host3Address = host3.getHostAddress();
        System.out.println(host3Address);
    }
}
