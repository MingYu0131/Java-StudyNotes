package com.JavaStudy.HspMiddleJavaTest.StringClass;

/**
 * @author mingyu
 * @version 1.0
 * StringBuilder是String类的拓展，效率最高，比StringBuffer还好，但是是线程不安全的，只能在单线程情况下使用
 * StringBuilder的方法和StringBuffer一样
 * 结论：
 * 1、如果字符串存在大量修改操作，并且是单线程情况，使用StringBuilder
 * 2、如果字符串存在大量修改操作，并且是多线程情况，使用StringBuffer
 * 3、如果我们的字符串很少修改，并且被多个对象引用，使用String（例如配置信息等）
 */
public class StringBuilder_ {
    public static void main(String[] args) {
        // 1. StringBuilder 继承 AbstractStringBuilder 类
        // 2. 实现了 Serializable ,说明 StringBuilder 对象是可以串行化(对象可以网络传输,可以保存到文件)
        // 3. StringBuilder 是 final 类, 不能被继承
        // 4. StringBuilder 对象字符序列仍然是存放在其父类 AbstractStringBuilder 的 char[] value;
        // 因此，字符序列是堆中
        // 5. StringBuilder 的方法，没有做互斥的处理,即没有 synchronized 关键字,因此在单线程的情况下使用StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
    }
}
