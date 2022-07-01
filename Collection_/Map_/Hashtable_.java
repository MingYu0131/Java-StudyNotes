package com.JavaStudy.HspMiddleJavaTest.Collection_.Map_;

import java.util.Hashtable;

/**
 * @author mingyu
 * @version 1.0
 * Hashtable和HashMap同级，存放K-V
 * 1、hashtable的键和值都不能为null，否则会抛出NullPointerException
 * 2、方法基本和HashMap一样
 * 3、Hashtable是线程安全的（synchronized）但是效率较低，HashMap是线程不安全的但是效率高
 */
@SuppressWarnings({"all"})
public class Hashtable_ {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("jojo", "ok");    //T
        hashtable.put(null, 100); //空指针异常
        hashtable.put(100, null); //空指针异常
        hashtable.put("pop", 50);
        hashtable.put("pop", 51);   //替换
        System.out.println(hashtable);
    }
}
