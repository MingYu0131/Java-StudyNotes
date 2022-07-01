package com.JavaStudy.HspMiddleJavaTest.IOStream_.InputStream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author mingyu
 * @version 1.0
 * 注意字节流和字符流的区别，字节流适合读取二进制文件（视频、音频），字符流适合读取文本类文件
 * 演示字节流InputStream底下的常用类FileInputStream的read()方法读取文件(字节输入流 文件--> 程序)
 * 在e盘下新建一个hello.txt，使用read方法读取他
 */
public class FileInputStream_ {


    public static void main(String[] args) {

    }

    /**
     * 使用read()读取文件，采用的是单个字符读取，效率较低
     */
    @Test
    public void ReadFile01(){
        String filePath = "e:\\hello.txt";
        int readData = 0;//单次读取到的asc码值
        FileInputStream fileInputStream = null;
        //创建fileInputStream对象用于读取文件
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。
            // 如果返回-1 , 表示读取完毕
        try {
            while ((readData = fileInputStream.read()) != -1){
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 优化使用read(byte[] b)来读取
     * 每次会读取字符数组b大小的字节数据
     * 返回值是实际读取到的字符数（最后会读取不到b.len的字节数），结束返回-1
     */
    @Test
    public void ReadFile02(){
        String filePath = "e:\\hello.txt";
        FileInputStream fileInputStream = null;
        //定义一次读取8个字节的数据
        byte[] b = new byte[8];
        //记录每次读取的字符数
        int readLen = 0;
        //创建fileInputStream对象用于读取文件
        try {
            fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //从该输入流读取最多 b.length 字节的数据到字节数组。
        //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。
        // 如果返回-1 , 表示读取完毕
        try {
            while ((readLen = fileInputStream.read(b)) != -1){
                String s = new String(b, 0, readLen);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
