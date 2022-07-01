package com.JavaStudy.HspMiddleJavaTest.Collection_;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author mingyu
 * @version 1.0
 * 集合是java用来保存多个数组的类，可以动态的保存多个数据（对象），比数组更方便
 * 并且提供了许多有用的操作方法，接下来介绍常用的集合类
 * java集合主要分为两大类，分别对应两个接口：Collection（单列集合）、Map（双列集合或Key-Value集合）
 * Collection接口又有两个接口继承，分别是List（有序）、Set（无序）。List下包括Vector、ArrayList（数组集合）、LinkedList（链表集合）。Set底下包括TreeSet和HashSet
 * Map接口下有三个类继承：HashMap、TreeMap、Hashtable
 * 具体的梳理韩顺平pdf里面的图
 */
public class Collection_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("asd");
        arrayList.add(3);   //自动装箱

        HashMap hashMap = new HashMap();
        hashMap.put(123, 145);
        hashMap.put("asd", "zxc");
    }
}
