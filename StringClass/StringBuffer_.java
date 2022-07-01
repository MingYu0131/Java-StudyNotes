package com.JavaStudy.HspMiddleJavaTest.StringClass;

/**
 * @author mingyu
 * @version 1.0
 * StringBuffer类是针对String类优化的类，可以更高效率实现对字符串内容的增加和修改删除
 * 在父类中 AbstractStringBuilder 有属性 char[] value,不是 final
 * 故和String类不一样，StringBuffer类的value数组存放在堆中而不是常量池中了
 * 因为 StringBuffer 字符内容是存在 char[] value, 所以在变化(增加/删除)时
 * 不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String
 *
 */
public class StringBuffer_ {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello");

        //开发中经常要实现String类和StringBuffer类的互相转换

        //String -> StringBuffer
        String str = "abc";
        //方法一，直接使用构造器，注意： 返回的才是 StringBuffer 对象，对 str 本身没有影响
        // public StringBuffer(String str) {
        //        super(str.length() + 16); //长度默认会加16的冗余空间，最后生成长度19的value char数组
        //        append(str);
        //    }
        StringBuffer sb = new StringBuffer(str);

        //方法二：先创建一个空的StringBuffer对象，再用append方法拼接
        StringBuffer sb2 = new StringBuffer();  //默认的无参构造器，创建容量为16的value char数组
        sb2 = sb2.append(str);

        //StringBuffer -> String
        //方法一：直接使用String的构造器
        StringBuffer sb3 = new StringBuffer("abc");
        String str2 = new String(sb3);

        //方法二：使用StringBuffer的toString方法
        String str3 = sb3.toString();

    }
}
