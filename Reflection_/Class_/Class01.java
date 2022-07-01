package com.JavaStudy.HspMiddleJavaTest.Reflection_.Class_;

import com.JavaStudy.HspMiddleJavaTest.Reflection_.Student;

/**
 * @author mingyu
 * @version 1.0
 * 内容：介绍Class类的细节
 * 1、Class也是类，因此也是继承Object的
 * 2、Class类对象不是用户new出来的，而是系统创建的
 * 3、对于某个类的Class类对象，在内存（JVM堆）中只有一份，因为类只会加载一次
 * 4、每个类的实例都会知道自己是由哪个Class实例所生成的（从这个角度看Class对象类似于一个模板）
 * 5、通过Class对象可以完整的得到一个类的完整内容（字段、方法、构造器、注解等等），有一系列API可以访问他们
 * 6、Class对象存放在堆中（对象都在堆中）
 * 7、类的字节码二进制数据，是放在方法区的，有些人称为类的元数据（二进制形式的字段、方法、构造器、注解等等）
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、传统方法new，编译成字节码后，会调用ClassLoader类进行类装载
        /*
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    return loadClass(name, false);
                }
         */
//        Student student = new Student();
        //2、通过反射的方式创建对象，注意类加载器创建同一个类的对象只会加载一次（Class对象整个类共用，存在堆中）
        /*也会调用ClassLoader
                // Returns the class's class loader, or null if none.
                static ClassLoader getClassLoader(Class<?> caller) {
                    // This can be null if the VM is requesting it
                    if (caller == null) {
                        return null;
                    }
                    // Circumvent security check since this is package-private
                    return caller.getClassLoader0();
                 }
         */
        Class<?> aClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.Student");
    }
}
