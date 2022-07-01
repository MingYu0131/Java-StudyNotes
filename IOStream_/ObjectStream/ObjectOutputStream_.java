package com.JavaStudy.HspMiddleJavaTest.IOStream_.ObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author mingyu
 * @version 1.0
 *  * 介绍对象流
 *  * 1、对象流就是能够将基本数据类型或者对象进行序列化和反序列化操作
 *  * 2、序列化：就是在保存数据时，同时保存数据的值和数据类型
 *  * 3、反序列化：在恢复/读取数据时，取得数据的值和数据类型
 *  * 4、需要让某个对象支持序列化机制，必须让其类是可序列化的，改类必须实现如下两个接口之一：
 *  *      （1）Serializable，这是一个标记接口，没有方法
 *  *      （2）Externalizable，该接口有方法需要实现，用此我们一般实现上面的Serializable接口
 *  演示ObjectOutputStream的使用
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String srcPath = "e:\\data.txt";

        //构造器需要传入一个实现了OutputStream类的对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(srcPath));

        //传入int基本数据类型，但是会自动装箱为Integer
        oos.write(120);// int -> Integer (实现了 Serializable)
        oos.writeChar('s');//char->Character(实现了 Serializable)
        oos.writeBoolean(false);
        //注意写入字符串使用writeUTF()方法
        oos.writeUTF("hmy");//String(实现了 Serializable)
        oos.writeObject(new Dog_("mybb", 10));
        System.out.println("序列化数据成功");
        oos.close();
    }
}


