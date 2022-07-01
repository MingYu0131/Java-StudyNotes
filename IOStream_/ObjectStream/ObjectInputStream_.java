package com.JavaStudy.HspMiddleJavaTest.IOStream_.ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

/**
 * @author mingyu
 * @version 1.0
 * 介绍对象流
 * 1、对象流就是能够将基本数据类型或者对象进行序列化和反序列化操作
 * 2、序列化：就是在保存数据时，同时保存数据的值和数据类型
 * 3、反序列化：在恢复/读取数据时，取得数据的值和数据类型
 * 4、需要让某个对象支持序列化机制，必须让其类是可序列化的，改类必须实现如下两个接口之一：
 *      （1）Serializable，这是一个标记接口，没有方法
 *      （2）Externalizable，该接口有方法需要实现，用此我们一般实现上面的Serializable接口
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws Exception {
        String srcPath = "e:\\data.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(srcPath));
        //注意反序列化的顺序要和序列化的顺序一致，不然会读取不到
        //也需要使用特定的read方法
        System.out.println(ois.read());
        System.out.println(ois.readChar());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readUTF());
        //注意dog对象是writeObject()方法传入的，编译类型已经向上转型为了Object类型
        Object dog = ois.readObject();
        System.out.println("运行类型:"+dog.getClass());//运行类型还是Dog_
        System.out.println(dog);
        // 重要的细节：
        //1、如果想使用Dog的方法需要向下转型
        //2、且Dog类，应该放在ObjectInputStream和ObjectOutputStream都能访问到的地方，不然会抛出异常（序列化和反序列化都要读取类信息）
        Dog_ dogNew = (Dog_) dog;
        System.out.println(dogNew.getAge());
    }
}
