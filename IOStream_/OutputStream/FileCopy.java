package com.JavaStudy.HspMiddleJavaTest.IOStream_.OutputStream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author mingyu
 * @version 1.0
 * 演示一个FileInputStream和FileOutputStream的综合用法文件拷贝
 * 文件拷贝的本质：将本地磁盘的文件通过字节输入流读取到java内存中，再通过字节输出流输出到磁盘上
 */
public class FileCopy {
    public static void main(String[] args) {

    }

    //完成 文件拷贝，将 e:\\apex.png 拷贝 d:\\
    @Test
    public void FileCopy(){
        String srcFilePath = "e:\\apex.png";

        String destFilePath = "d:\\apex.png";
        //定义好需要使用的字节数组，使用1024为一个窗口读取
        byte[] b = new byte[1024];
        //定义每次读取的实际字节数（最后一次会小于1024,结束时为-1），接受read的返回值
        int readData = 0;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //使用循环读取，一边读一边写
            while ((readData = fileInputStream.read(b)) != -1){
                //每次读取应该都从b数组取0~readData个字节，才不会导致最后一次出错
                fileOutputStream.write(b, 0, readData);
            }
            System.out.println("拷贝ok~~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
