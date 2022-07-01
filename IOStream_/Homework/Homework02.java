package com.JavaStudy.HspMiddleJavaTest.IOStream_.Homework;

import java.io.*;

/**
 * @author mingyu
 * @version 1.0
 * 使用BufferedReader读取一个文本文件，为每行加上行号，再连同内容一并输出到屏幕上
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\story.txt";
        //注意：在Windows操作系统中，读写是互斥的，你既然已经打开该文件，就没法再另外对这个文件进行写。
        //所以说如果对这同一个文件调用writer和reader就会出问题
        //更新：虽然测试可以边读边写同一个文件但是尽量不要这样做
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        //注意：在创建FIleWriter对象的时候如果不传入true，那么初始化时就会立马清空文件内容
//        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true));
        //思考是否使用字节流可以解决这个问题：不行，OutputStream如果不设置追加写，在构造器初始化时也会清空文件
        //解决方案：将读写分开。先使用读，把要写入的内容先放在一个String内（程序内存中），再最后统一写入文件（覆盖写）
        String line;
        String newLine = "";
        int lineNum = 1;
        while ((line = br.readLine()) != null){
            newLine += lineNum++ +" "+ line + '\n';
//            bw.write(newLine);
//            bw.newLine();
        }
        System.out.println(newLine);
        br.close();
//        bw.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write(newLine);
        bw.close();
        System.out.println("完成！");
    }
}
