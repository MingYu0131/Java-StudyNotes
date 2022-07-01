package com.JavaStudy.HspMiddleJavaTest.Collection_.Map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author mingyu
 * @version 1.0
 * 查看TreeMap的put方法源码
 */
@SuppressWarnings({"all"})
public class TreeMapSource{
    public static void main(String[] args) {
        //如果没有使用构造器声明比较器，默认是调用Key的CompareTo方法进行元素的比较
//        TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //根据字符串长度排序，重复的元素会更新Value：return t.setValue(value);
                return ((String) o1).length() - ((String) o2).length();
            }
        });
//        treeMap.put(new Object(), 5); //Object没实现compareable接口，没有Comparator方法，会报错
        treeMap.put("tom", 15);
        treeMap.put("m", 55);
        treeMap.put("sas", 40); //使用字符串长度比较时，Key不会被入树，但是和“sas”相同长度的Value会更新
        System.out.println(treeMap);
        /*
            1、构造器. 把传入的实现了 Comparator 接口的匿名内部类(对象)，传给给 TreeMap 的 comparator
             public TreeMap(Comparator<? super K> comparator) {
                    this.comparator = comparator;
                 }
            2、调用put方法
                2.1第一次添加，root默认为null，将第一次的K-V直接作为root，TreeMap的元素使用Entry<K,V>存储（实现了Map.Entry接口）
                 Entry<K,V> t = root;
                if (t == null) {
                    compare(key, key); // type (and possibly null) check

                    root = new Entry<>(key, value, null);
                    size = 1;
                    modCount++;
                    return null;
                }
                2.2以后添加
                Comparator<? super K> cpr = comparator; //comparator是TreeMap的属性，由用户从构造器传入的匿名内部类决定
                if (cpr != null) {  //程序员实现了比较器
                    do {    //这个Do-While遍历整个红黑树
                        parent = t;
                        cmp = cpr.compare(key, t.key);
                        if (cmp < 0)
                            t = t.left;
                        else if (cmp > 0)
                            t = t.right;
                        else
                            return t.setValue(value);       //cmp = 0，认为重复了，只更新一次value
                    } while (t != null);
                }
                else {  //程序员没实现比较器
                    if (key == null)
                        throw new NullPointerException();
                    @SuppressWarnings("unchecked")
                        Comparable<? super K> k = (Comparable<? super K>) key;
                    do {
                        parent = t;
                        cmp = k.compareTo(t.key);       //调用Key对象的compareTo（如果Key对象的类没实现比较器就会抛出ClassCastException）
                        if (cmp < 0)
                            t = t.left;
                        else if (cmp > 0)
                            t = t.right;
                        else
                            return t.setValue(value);
                    } while (t != null);
                }
                Entry<K,V> e = new Entry<>(key, value, parent);
                if (cmp < 0)        //构建红黑树的parent属性
                    parent.left = e;
                else
                    parent.right = e;
                fixAfterInsertion(e);
                size++;
                modCount++;
                return null;
         */
    }
}
