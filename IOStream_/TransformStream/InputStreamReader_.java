package com.JavaStudy.HspMiddleJavaTest.IOStream_.TransformStream;

import java.io.*;

/**
 * @author mingyu
 * @version 1.0
 * 介绍转换流：（可以转换字节流到字符流从而解决编码问题的流）
 * 0、用于解决文件的编码问题，转换流可以指定读取文件的编码格式和写入文件的编码格式，在构造器中指定
 * 1、InputStreamReader：是Reader的子类属于字符流，可以将InputStream（字节流）包装（转换）为Reader（字符流）
 * 2、OutputStreamWriter：Writer的子类，可以将OutputStream（字节流）包装为Writer（字符流）
 * 3、当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文问题，所以建议将字节流转换为字符流
 * 案例：将字节流包装成字符流，对文件按照指定的编码进行读取（默认是utf-8）
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        //txt文件默认是utf-8，首先将其编码转为gbk（国标ANSI）
        String srcPath = "e:\\a.txt";
        //InputStreamReader的构造器，和BufferedStream类似，可以接收InputStream的子类对象，第二个参数可以指定按照什么编码进行读取
        InputStreamReader ips = new InputStreamReader(new FileInputStream(srcPath), "gbk");
        BufferedReader br = new BufferedReader(ips);
        //可以正常的读取
        System.out.println(br.readLine());
        //只需要关闭外层流，里层会关闭
        br.close();

    }
}
