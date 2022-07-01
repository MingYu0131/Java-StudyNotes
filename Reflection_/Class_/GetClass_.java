package com.JavaStudy.HspMiddleJavaTest.Reflection_.Class_;

import com.JavaStudy.HspMiddleJavaTest.Reflection_.Student;

/**
 * @author mingyu
 * @version 1.0
 * content:演示得到Class对象的六种方法
 * java程序在计算机中有三个阶段：1、编译阶段-Cat.java，用javac编译之后形成Cat.class字节码文件
 *                          2、Class类阶段（类加载阶段），类加载器将字节码文件加载到类加载器得到Class类对象存放在堆中
 *                          3、Runtime运行阶段
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、从类的全路径获取Class对象，多用于.java文件还未编译时，多用于处理配置文件
        String classFullName = "com.JavaStudy.HspMiddleJavaTest.Reflection_.Student";
        Class<?> cls1 = Class.forName(classFullName);
        System.out.println(cls1 + " " + cls1.hashCode());

        //2、类名.class ，多用于参数传递
        Class cls2 = Student.class;
        System.out.println(cls2 + " " + cls2.hashCode());

        //3、对象.getClass(),多用于已经有对象实例了，需要查看其运行类型
        Student student = new Student();
        Class<? extends Student> cls3 = student.getClass();
        System.out.println(cls3 + " " + cls3.hashCode());

        //4、通过类加载器来获取到类的Class对象
        //(1)先得到类加载器
        ClassLoader classLoader = student.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class<?> cls4 = classLoader.loadClass(classFullName);
        System.out.println(cls4 + " " + cls4.hashCode());

        //5. 基本数据(int, char,boolean,float,double,byte,long,short) 按如下方式得到 Class 类对象
        //integerClass这个Class对象，保存了Integer包装类的所有类信息，是java虚拟机创建的，只有一个，所以其与type的hashcode相同
        Class<Integer> integerClass = int.class;
        //注意区别，int.class指的是int的Class对象,Integer.class是Integer的Class的类对象.
        Class<Integer> integerClass1 = Integer.class;
        System.out.println(integerClass + " " + integerClass.hashCode());
        System.out.println(integerClass1 + " " + integerClass1.hashCode());

        //6. 基本数据类型对应的包装类，可以通过 .TYPE 得到 Class 类对象
        //TYPE是定义在包装类中的常量，用于存储其对应基本类型的Class对象
        Class<Integer> type = Integer.TYPE;
        Class<Double> type1 = Double.TYPE;
        System.out.println(type + " " + type.hashCode());
        System.out.println(type1 + " " + type1.hashCode());
    }
}
