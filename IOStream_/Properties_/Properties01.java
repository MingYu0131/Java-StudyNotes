package com.JavaStudy.HspMiddleJavaTest.IOStream_.Properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author mingyu
 * @version 1.0
 * 介绍Properties类：专门用来读写配置文件的集合类（也算IO流）
 * 1、配置文件的格式：键=值（键值对不需要有空格，值不需要使用引号，默认类型是String）
 * 常用方法：
 * load:加载配置文件的键值对到Properties对象
 * list：将数据显示到指定设备
 * getProperty（key）：根据键获取值
 * setProperties（key，value）：设置键值对到Properties对象
 * store：将Properties中的键值对存储到配置文件，在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码
 * 案例：使用Properties读取src:\mysql.properties配置文件
 * 遍历：1、使用propetties.keyset()获取key，再使用迭代器进行遍历或直接增强for遍历keyset
 *      2、使用properties.stringPropertyNames()获取keySet再遍历
 *      3、使用entry = properties.entrySet()返回的属性键值对实体，再entry.getKey()， entry.getValue()
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        //直接打印在控制台上，list的形参是list(PrintStream out)，可以传进标准输出流System.out
        System.out.println(System.out.getClass());
        properties.list(System.out);
        //根据Key值获取内容
        String user;
        user = properties.getProperty("user");
        System.out.println(user);
    }
}
