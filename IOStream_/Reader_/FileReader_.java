package com.JavaStudy.HspMiddleJavaTest.IOStream_.Reader_;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author mingyu
 * @version 1.0
 * 注意字节流和字符流的区别，字节流适合读取二进制文件（视频、音频），字符流适合读取文本类文件
 * Reader和Writer是字符流的两个抽象类，所有的字符流方法都来自这两个抽象类
 * 介绍从Reader抽象类派生而来，父类是InputStreamReader，FileReader
 * 案例：使用 FileReader 从 e:\\story.txt 读取内容，并显示
 */
public class FileReader_ {
    public static void main(String[] args) {

    }

    /**
     * 读取story.txt，使用FileReader.read()单个字符的方式读取文件
     */
    @Test
    public void ReadFile01() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        //用来接收单次的字符asc码
        int data = 0;
        try {
            fileReader = new FileReader(filePath);
            //读取到文件末尾时返回-1，其他返回单个字符的asc值
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println("读取成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 读取story.txt，使用FileReader.read(byte[] b)依次读取字节数组长度个字节的方式读取文件
     */
    @Test
    public void ReadFile02() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        //用来接收单次字符的char数组
        //注意与字节流区分，字节流使用的数组是byte数组，用来存放asc值，字符数组直接使用char数组
        char[] b = new char[8];
        int readLen = 0;
        try {
            fileReader = new FileReader(filePath);
            //读取到文件末尾时返回-1，其他返回当次读取的字符数
            while ((readLen = fileReader.read(b)) != -1) {
                String str = new String(b, 0, readLen);
                System.out.print(str);
            }
            System.out.println("读取成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
