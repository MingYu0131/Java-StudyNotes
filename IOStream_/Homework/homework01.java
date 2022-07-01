package com.JavaStudy.HspMiddleJavaTest.IOStream_.Homework;

import java.io.*;

/**
 * @author mingyu
 * @version 1.0
 * 1、判断e盘下是否有文件夹mytemp，如果没有就创建mytemp
 * 2、在e:\\mytemp目录下创建文件hello.txt
 * 3、如果hello.txt已经存在，提示该文件已经存在，就不再重复创建
 */
public class homework01 {
    public static void main(String[] args) throws IOException {
        String dirPath = "e:\\mytemp";
        String filePath = "e:\\mytemp\\hello.txt";
        File file1 = new File(dirPath);
        File file2 = new File(filePath);
        if(file1.mkdir()){
            System.out.println("e:\\mytemp不存在，创建之");
        }else {
            System.out.println("e:\\mytemp已经存在");
        }
        if(!file2.exists()){
            file2.createNewFile();
            System.out.println("文件hello创建成功！写入一些文字");
//            FileWriter fileWriter = new FileWriter(file2);
//            fileWriter.write("写入流！");
//            //一定要记得关闭流！
//            fileWriter.close();
            //需要指定编码，使用转换流
            OutputStreamWriter gbk = new OutputStreamWriter(new FileOutputStream(file2), "gbk");
            gbk.write("写入一些东西");
            gbk.close();

        }else{
            System.out.println("文件hello已经存在！");
        }
    }
}
