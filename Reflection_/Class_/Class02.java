package com.JavaStudy.HspMiddleJavaTest.Reflection_.Class_;

import com.JavaStudy.HspMiddleJavaTest.Reflection_.Student;

import java.lang.reflect.Field;

/**
 * @author mingyu
 * @version 1.0
 * 内容：介绍Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws Exception{
        //1、获取对象
        //这里的Class<?>泛型，代表aClass对象的类型未知，会根据传入的全路径名而改变
        Class<?> aClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.Student");
        //2、输出aClass
        //可以看到aClass并不等于Student的一个对象，只是包含了Student类信息的一个对象
        System.out.println(aClass);//输出aClass对象是哪个类的Class对象，可以看到是Student类的
        System.out.println(aClass.getClass());//输出aClass对象的运行时类型，是Class类型
        //3、得到包名
        System.out.println(aClass.getPackage());
        //4、得到全类名
        System.out.println(aClass.getName());
        //5、创建对象实例
        Student student = (Student) aClass.newInstance();
        System.out.println(student);
        //6、通过反射获取属性age
        Field age = aClass.getField("age");
        //通过反射获取student对象的age属性
        System.out.println(age.get(student));
        //7、通过反射给属性赋值
        age.set(student, 8);
        System.out.println(age.get(student));
        //8、通过反射获取类的所有字段
        System.out.println("=======Student类的所有能访问到的字段如下========");
        Field[] fields = aClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }
    }
}
