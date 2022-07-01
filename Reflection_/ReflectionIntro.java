package com.JavaStudy.HspMiddleJavaTest.Reflection_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author mingyu
 * @version 1.0
 * 内容：通过一个案例引入反射机制
 * 问题：1、根据配置文件re.properties指定的信息，创建Cat对象并调用方法hi
 *      classfullpath = com.JavaStudy.BasicJavaTest.Student
 *      method = study
 *      2、思考使用现在的技术能否实现（应该是不能的，不能用类名和方法名的字符串直接创建对象，引出反射）
 *      3、这样的需求在学习框架的时候特别多，即通过外部配置文件，在不修改源码的情况下来控制程序
 *      （即只需要修改re.properties不用重新编译源代码就能直接调用不同的方法），符合设计模式的ocp原则（开闭原则：不修改代码，拓展功能）
 * 反射的概念：
 *      1、反射机制允许程序在执行期借助Reflection API取得任何类的内部信息（比如成员变量、构造器、成员方法等等），并能对其进行操作
 *      2、在加载完类之后，在堆中会产生一个Class类型的对象（一个类只有一个Class对象），这个对象包含了类的完整结构信息，通过这个对象可以得到
 *      类的结构。这个Class对象就像一面镜子，透过这个镜子看到类的结构，所以形象的称之为：反射
 */
public class ReflectionIntro {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        Object classfullpath = properties.get("classfullpath");
        System.out.println(classfullpath.toString());
        Object method = properties.get("method");
        System.out.println(method.toString());
        //可以看到只能读取到字符串

        //使用反射
        //1、加载类，返回包含了Student对象类信息的Class对象aClass
        Class aClass = Class.forName((String) classfullpath);
        //2、通过aClass对象获取到对象实例
        Object o = aClass.newInstance();
        //可以看到运行类型已经是com.JavaStudy.BasicJavaTest.Student
        System.out.println(o.getClass());
        //3、通过aClass得到加载的类的method方法
        //使用Method类接收方法的对象，在反射中，可以把类和方法视为对象，体现了万物皆对象的概念
        Method method1 = aClass.getMethod((String) method);
        //4、通过 method1 调用方法: 即通过方法对象来实现调用方法
        //传统方法 对象.方法() , 反射机制 方法.invoke(对象)
        method1.invoke(o);
    }
}
