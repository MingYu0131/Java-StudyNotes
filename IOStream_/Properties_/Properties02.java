package com.JavaStudy.HspMiddleJavaTest.IOStream_.Properties_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author mingyu
 * @version 1.0
 * 案例：演示调用Properties类完成创建一个配置信息文件，并写入和修改信息
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/re.properties"));
        properties.setProperty("user", "mybb包子");//注意保存时，是中文的 unicode 码值
        properties.setProperty("pwd", "hmy181204");
        properties.setProperty("ip", "192.168.100.2");
        ////创建 //1.如果该文件没有 key 就是创建 //2.如果该文件有 key ,就是修改
        properties.setProperty("ip", "192.168.100.1");

        //store的两个参数，一个是输出字符流，一个是注解，会写在文件的开头
        properties.store(new FileWriter("src/re.properties", true), "配置文件信息");
        System.out.println("保存配置文件成功");
    }
}
