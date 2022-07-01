package com.JavaStudy.HspMiddleJavaTest.IOStream_.Buffered_;

import java.io.*;

/**
 * @author mingyu
 * @version 1.0
 * 使用BufferedWriter和BufferedReader实现文件的拷贝
 */
public class BufferedCopy {
    public static void main(String[] args) {
        //1. BufferedReader 和 BufferedWriter 是安装字符操作
        // 2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
        //使用BufferedInputStream、BufferedOutputStream去操作二进制文件
        String srcPath = "e:\\story.txt";
        String destPath = "e:\\a.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String line;
        try {
            bufferedReader = new BufferedReader(new FileReader(srcPath));
            bufferedWriter = new BufferedWriter(new FileWriter(destPath));
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("拷贝成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //注意BufferedWriter和FileWriter一样，也要刷新或者关闭后才能成功写入文件
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
