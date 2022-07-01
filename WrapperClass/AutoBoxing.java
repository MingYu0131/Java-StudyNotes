package com.JavaStudy.HspMiddleJavaTest.WrapperClass;

import java.lang.Integer;

/**
 * @author mingyu
 * @version 1.0
 * 测试包装类的自动装箱与自动拆箱
 */
public class AutoBoxing {
    public static void main(String[] args) {
        //JDK5之前是手动拆箱与手动装箱
        //手动装箱：int -> Integer
        int n1 = 100;
        Integer integer1 = new Integer(100);
        Integer integer2 = Integer.valueOf(n1);

        //手动拆箱：Integer -> int
        int n2 = integer1.intValue();

        //自动装箱：int -> Integer
        int n3 = 200;
        Integer integer3 = n3;  //已优化，底层使用的是 Integer.valueOf(n3)

        //自动拆箱：Integer -> int
        int n4 = integer3;  //; //底层仍然使用的是 intValue()方法
    }
}
