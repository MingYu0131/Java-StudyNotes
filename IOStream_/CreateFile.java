package com.JavaStudy.HspMiddleJavaTest.IOStream_;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author mingyu
 * @version 1.0
 * 在E盘下使用三种不同的方式创建文件
 */
public class CreateFile {
    public static void main(String[] args) {

    }

    @Test
    //方式1：直接根据路径构建一个文件对象
    public void create01(){
        String pathFile = "e:\\news1.txt";
        File file = new File(pathFile);
        try {
            System.out.println("文件创建成功");
            //上面的new File()只是在JVM虚拟机的堆中创建了文件对象，下面的createNewFile方法才是真正的创建文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式2：根据父目录文件和子路径构建
    public void create02(){
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        try {
            System.out.println("创建文件成功！");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式3：根据父目录和子路径构建
    public void create03(){
        String parentPath = "e:\\";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try {
            System.out.println("创建文件成功！");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
