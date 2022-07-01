package com.JavaStudy.HspMiddleJavaTest.IOStream_.OutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author mingyu
 * @version 1.0
 * 要求: 请使用 FileOutputStream 在 a.txt 文件，中写入 “hello，world”. , 如果文件不存在，会创建 文件(注意：前提是目录已经存在.)
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /**
     *演示 fileOutputStream.write()的两种用法，传入单个字符和传入字节数组byte[] b
     * 因为字符其实对应的是int，所以可以使用字节数组存
     */
    @Test
    public void WriteFile(){
       String filePath = "e:\\a.txt";
       FileOutputStream  fileOutputStream = null;
        try {
            //有两种FileOutputStream对象的初始化方式，根据业务需求选择
            //1. new FileOutputStream(filePath) 创建方式，当写入内容是，会覆盖原来的内容，IO流默认都是覆盖写
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容是，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
            fileOutputStream.write('H');
            //写入一个字符串
            //str.getBytes()可以把字符串转为字符数组
            String str = "hmy";
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            //write(byte[] b, int off, int len) 将 len 字节从位于偏移量 off 的指定字节数组写入此文件输出流
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8), 0, 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
