package com.JavaStudy.HspMiddleJavaTest.IOStream_;

import java.io.File;

/**
 * @author mingyu
 * @version 1.0
 * 如何获取到文件的大小，文件名，路径，父目录，是文件还是目录（目录本质也是文件，一种特殊的文件），是否存在
 */
public class FileInformation {
    public static void main(String[] args) {
        File file = new File("e:\\news1.txt");

        //调用相应的方法得到对应信息
        System.out.println("文件名字：" + file.getName());
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("文件的父级目录：" + file.getParent());
        System.out.println("文件的大小（字节）：" + file.length());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("是不是文件：" + file.isFile());
        System.out.println("是不是目录：" + file.isDirectory());
    }

}
