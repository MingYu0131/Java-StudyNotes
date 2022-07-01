package com.JavaStudy.HspMiddleJavaTest.Reflection_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author mingyu
 * @version 1.0
 * 内容：介绍反射的相关类
 * 1、Class ：代表一个类，Class对象表示某个类加载后在堆中的对象
 * 2、Method ：代表类的方法，Method对象表示某个类的方法
 * 3、Field ：代表类的成员变量，Filed对象表示某个类的成员变量
 * 4、Constructor ：代表类的构造方法，其对象表示构造器
 */
public class ReflectionClass_01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        Object classfullpath = properties.get("classfullpath");
        System.out.println(classfullpath.toString());
        Object method = properties.get("method");
        //Class ：代表一个类，Class对象表示某个类加载后在堆中的对象
        Class aClass = Class.forName((String) classfullpath);
        Object o = aClass.newInstance();
        System.out.println(o.getClass());
        //Method ：代表类的方法，Method对象表示某个类的方法
        Method method1 = aClass.getMethod((String) method);
        method1.invoke(o);

        //Field ：代表类的成员变量，Filed对象表示某个类的成员变量
        //注意getFiled不能读取private字段，可以使用读取Get方法的办法读取
//        Field name = aClass.getField("name");
        Field age = aClass.getField("age");
        //Constructor ：代表类的构造方法，其对象表示构造器
        Constructor constructor = aClass.getConstructor();//无参构造器
        System.out.println(constructor);
        Constructor constructor1 = aClass.getConstructor(String.class);//传入的 String.class 就是 String 类的 Class 对象
        System.out.println(constructor1);
    }
}
