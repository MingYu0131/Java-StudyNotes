package com.JavaStudy.HspMiddleJavaTest.Reflection_;

import java.lang.reflect.Constructor;

/**
 * @author mingyu
 * @version 1.0
 * 内容：演示使用反射创建对象，反射爆破使用private构造器
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.Student");
        //1、通过反射调用public无参构造器创建对象
        Object s = studentClass.newInstance();
        //2、调用public有参构造器创建对象
        //2.1先获取到对应的构造器，注意getConstructor()是可变参数，根据传入构造器的形参的Class对象变化
        Constructor<?> studentClassConstructor = studentClass.getConstructor(String.class);
        //2.2使用构造器传入形参
        Object mybb = studentClassConstructor.newInstance("mybb");
        System.out.println(mybb);
        //3、通过非public的有参构造器创建对象
        //3.1得到private的构造器
        Constructor<?> studentClassDeclaredConstructor = studentClass.getDeclaredConstructor(String.class, int.class);
        //3.2爆破，也就是暴力破解，让private成员可以被访问到，可以理解是留给java程序员的后门
        studentClassDeclaredConstructor.setAccessible(true);
        //3.3创建对象实例
        Object hmy = studentClassDeclaredConstructor.newInstance("hmy", 10);
        System.out.println(hmy);

    }

}

