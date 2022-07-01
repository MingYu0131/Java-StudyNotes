package com.JavaStudy.HspMiddleJavaTest.IOStream_.Buffered_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author mingyu
 * @version 1.0
 * BufferedReader和BufferedWriter属于字符流，是包装流
 * 使用BufferedReader读取文本文件
 */
public class BufferedReader__ {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("e:\\a.txt"));
        //读取
        String line;
        // 按行读取, 效率高
        // 说明 //1. bufferedReader.readLine() 是按行读取文件
        // 2. 当返回 null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) { System.out.println(line); }
        //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流FileReader
        bufferedReader.close();
    }
}
