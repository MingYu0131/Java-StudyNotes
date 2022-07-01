package com.JavaStudy.HspMiddleJavaTest.StringClass;

/**
 * @author mingyu
 * @version 1.0
 * 判断输出
 */
public class StringExercise01 {
    public static void main(String[] args) {
        //方法一创建字符串：先从常量池查看是否有"hmy"数据空间，如果有就直接指向，如果没有就创建再指向，a最终指向常量池的空间地址
        String a = "hmy";
        //方法二创建字符串：先在堆中创建空间，里面维护了value属性，指向常量池hmy空间，如果常量池中没有hmy就创建，如果有直接将value指向它
        //b最终指向的是堆中的地址空间
        String b = new String("hmy");

        System.out.println(a.equals(b));//T
        System.out.println(a==b);//F
        //String.intern()方法，最终返回的是常量池的地址（对象）
        System.out.println(a==b.intern());//T
        System.out.println(b==b.intern());//F
    }
}
