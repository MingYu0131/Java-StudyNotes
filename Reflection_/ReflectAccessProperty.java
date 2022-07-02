package com.JavaStudy.HspMiddleJavaTest.Reflection_;

import java.lang.reflect.Field;

/**
 * @author mingyu
 * @version 1.0
 * 内容：演示使用反射操作属性
 */
public class ReflectAccessProperty {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("com.JavaStudy.HspMiddleJavaTest.Reflection_.Student");
        Object o1 = studentClass.newInstance();
        //o1的运行类型就是Student
        System.out.println(o1.getClass());

        //1、使用反射获取public属性
        Field age = studentClass.getField("age");
        //更改属性
        age.set(o1, 15);
        //获取属性
        Object o = age.get(o1);
        System.out.println(o);

        //2、使用反射操作private static属性
        Field level = studentClass.getDeclaredField("level");
        //私有属性想操作都要暴破
        level.setAccessible(true);
//        level.set(o1, 10);
        //因为level属性是静态属性属于类，所以归属对象也可以填null
        level.set(null, 100);
//        System.out.println(level.get(o1));
        //静态属性也可以在get传入null
        System.out.println(level.get(null));
    }
}
