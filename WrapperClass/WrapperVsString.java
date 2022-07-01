package com.JavaStudy.HspMiddleJavaTest.WrapperClass;

/**
 * @author mingyu
 * @version 1.0
 * 测试包装类和字符串的转换
 */
public class WrapperVsString {
    public static void main(String[] args) {
        //String -> Integer
        String s1 = "123";
        Integer integer = new Integer(s1);  //方法一，通过构造器实现转换
        integer = Integer.parseInt(s1); //方法二，发生了自动装箱

        //Integer -> String
        Integer n1 = 123;
        String s2 = n1 + "";    //方式一
        s2 = n1.toString(); //方式二，利用Integer类重写的toString
        s2 = String.valueOf(n1);    //方式三



    }
}
