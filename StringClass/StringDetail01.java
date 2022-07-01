package com.JavaStudy.HspMiddleJavaTest.StringClass;

/**
 * @author mingyu
 * @version 1.0
 */
public class StringDetail01 {
    public static void main(String[] args) {
        // 以下代码创建了几个对象？
        //实际只创建了一个对象，"hmy" + "mybb" 优化-> "hmymybb"
        String a = "hmy" + "mybb";

        //以下代码常量池中创建了几个对象？三个。
        //1、对d = b + c进行断点调试，发现底层是先创建 StringBuilder sb = new StringBuilder();再sb.append(a); sb.append(b)
        //2、最后再调用StringBuilder.toString() return new String(value, 0, count);方法将一个新的String对象返回给d。
        //重要规则：String c = "ab"+"cd";常量相加，看的是常量池。String c = a + b;变量相加，其实在堆中。
        String b = "hmy";
        String c = "mybb";
        String d = b + c;
    }
}
