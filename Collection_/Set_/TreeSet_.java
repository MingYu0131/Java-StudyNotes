package com.JavaStudy.HspMiddleJavaTest.Collection_.Set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author mingyu
 * @version 1.0
 * 单列对象，元素不重复，需要排序：TreeSet【底层是TreeMap(底层是红黑树)，实现了Comparator接口，可以根据需要对数据排序】
 */
@SuppressWarnings({"all"})
public class TreeSet_ {
    public static void main(String[] args) {
        //1、使用默认无参构造器创建TreeSet对象，元素也是无序的（按hash值决定index值顺序）
        //2、希望元素按照首字母顺序排序，可以使用TreeSet提供的一个带参构造器，转入一个Comparator匿名内部类决定比较规则

//        TreeSet treeSet = new TreeSet();
//        TreeSet treeSet = new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                //调用String的compareTo方法
//                return ((String) o1).compareTo((String) o2);
//            }
//        });
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //试图根据字符串长度来排序
                //注意底层put方法在调用Comparator时分为三个情况，大于0小于0和等于0，等于0时不添加，大于小于0会添加到对应位置（Set不允许重复元素的一种体现）
                //所以这里想根据字符串长度排序，相同长度的字符串只会保留最开始添加的那个
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        treeSet.add("jojo");
        treeSet.add("hmy");
        treeSet.add("mybb");
        treeSet.add("www");
        System.out.println(treeSet);
    }
}
