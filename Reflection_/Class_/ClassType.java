package com.JavaStudy.HspMiddleJavaTest.Reflection_.Class_;

import java.io.Serializable;

/**
 * @author mingyu
 * @version 1.0
 * 内容：展示哪些类有Class对象
 */
public class ClassType {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;//接口，接口的本质也是类
        Class<Integer[]> cls3 = Integer[].class;//数组，数组本质也是对象
        Class<Double[][]> cls4 = Double[][].class;//二维数组
        Class<Thread.State> cls5 = Thread.State.class;//Thread底下的枚举类型State，本质也是类
        Class<Deprecated> cls6 = Deprecated.class;//注解，本质也是类
        Class<Long> cls7 = long.class;//基本数据类型，会返回其包装类中定义的Class对象
        Class<Void> cls8 = void.class;//void，空返回值，本质也是一个类
        Class<Class> cls9 = Class.class;//Class对象当然也有自己的Class对象

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }
}
